package com.pccc.es.elasticsearch_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pccc.es.elasticsearch_demo.pojo.Article;
import org.apache.lucene.index.Terms;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.fetch.subphase.highlight.Highlighter;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class ElasticsearchDemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchDemoApplicationTests.class);
    private TransportClient client;
    private Article article;
    @Before
    public void init() throws UnknownHostException {
        logger.info("开始setting");
        Settings settings = Settings.builder()
                .put("cluster.name", "hello")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9200));
//        client.admin().indices().prepareCreate("index_hello").get();
//        client.close();
    }
    ElasticsearchDemoApplicationTests() throws IOException {
    }


    @Test
    public void setMappings() throws IOException {

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("article")
                 .startObject("properties")
                     .startObject("id")
                         .field("type", "long")
                         .field("store", true)
                     .endObject()
                     .startObject("title")
                        .field("type", "text")
                        .field("store", true)
                        .field("analizer", "ik_smart")
                     .endObject()
                     .startObject("content")
                        .field("type", "text")
                        .field("store", true)
                        .field("analizer", "ik_smart")
                     .endObject()
                    .endObject()
                .endObject()
            .endObject();

        client.admin().indices()
                .preparePutMapping("index_hello")
                .setType("article")
                .setSource(builder)
                .setIndicesOptions(IndicesOptions.lenientExpand())
                .get();
        client.close();
    }
    public void addDocument1() throws  Exception{
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", "1l")
                .field("title", "明朝那些事")
                .field("content", "haha")
                .endObject();
        IndexResponse response = client.prepareIndex().setIndex("index_hello")
                .setType("article").setId("1").setSource(builder).get();
        client.close();

    }
    //添加文档的第二种方式
    public void addDocument2() throws Exception{
        article.setId(2l);
        article.setTitle("西游记");
        article.setContent("大闹天宫");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(article);
        System.out.println(s);
        client.prepareIndex("index_Hello","article","3")
                .setSource(s, XContentType.JSON)
                .get();
        client.close();
    }
    //根据id查询
    @Test
    public void searchById() throws Exception{
        IdsQueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1", "2", "3");
        SearchResponse searchResponse = client.prepareSearch("index_Hello").setTypes("article")
                .setQuery(queryBuilder).get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("总记录数："+hits.getTotalHits());
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            Map<String, Object> map = hit.getSourceAsMap();
            String id1 = (String)map.get("id");
            String article = (String)map.get("article");
            String content = (String)map.get("content");
        }
        client.close();

    }
    @Test
    public void searchByTerm() throws Exception{
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder title = highlightBuilder.field("title");//设置高亮字段（域）
        HighlightBuilder preTags = highlightBuilder.preTags("<em>");//设置高亮前缀
        HighlightBuilder postTags = highlightBuilder.postTags("</em>");//设置高亮后缀
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title","haha");
        SearchResponse searchResponse = client.prepareSearch("index_Hello").setTypes("article")
                .setQuery(queryBuilder)
                .setFrom(0)//在client设置完查询条件后设置分页起始行
                .setSize(5)//在client设置完查询条件后设置分页行数
                .highlighter(highlightBuilder)//设置高亮显示
                .get();
        SearchHits hits = searchResponse.getHits();

        System.out.println("总记录数："+hits.getTotalHits());
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            //先获取高亮部分数据
            Map<String, HighlightField> fields = hit.getHighlightFields();
            HighlightField content1 = fields.get("title");
            Text[] fragments = content1.getFragments();
            if (null!=fragments && fragments.length != 0){
                Text highlight = fragments[0];
                System.out.println(highlight);
            }
            String id = hit.getId();
            Map<String, Object> map = hit.getSourceAsMap();
            String id1 = (String)map.get("id");
            String article = (String)map.get("article");
            String content = (String)map.get("content");
        }
        client.close();
    }

    @Test
    public void queryStringQuery() throws Exception{
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery("阿凡达")
                .defaultField("content");//从content字段（域）中查询
        SearchResponse searchResponse = client.prepareSearch("index_Hello").setSearchType("article").setQuery(queryBuilder)
                .get();
        SearchHits hits = searchResponse.getHits();
        hits.getTotalHits();//统计得到的而总数
        for (SearchHit hit : hits) {
            String id = hit.getId();
            Map<String, Object> map = hit.getSourceAsMap();
            String id1 = (String)map.get("id");
            String article = (String)map.get("article");
            String content = (String)map.get("content");
        }
        client.close();
    }
}
