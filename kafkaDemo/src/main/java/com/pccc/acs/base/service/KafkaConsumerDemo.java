package com.pccc.acs.base.service;

import java.util.Properties;

/**
 * @Author jinquanhua
 * @date 2021/2/20 10:26
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {

        Properties prop = new Properties();
        prop.put("bootstrap","127.0.0.1:9092");
        prop.put("bootstrap","127.0.0.1:9092");
        prop.put("bootstrap","127.0.0.1:9092");
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(prop);

    }
}
