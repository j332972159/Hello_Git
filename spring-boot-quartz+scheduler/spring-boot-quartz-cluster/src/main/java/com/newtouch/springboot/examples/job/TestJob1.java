package com.newtouch.springboot.examples.job;

import com.newtouch.springboot.examples.service.TestService;
import com.newtouch.springboot.examples.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
@DisallowConcurrentExecution
public class TestJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            TestService testService = (TestService) SpringContextUtil.getBean("testServiceImpl");
            String group = jobExecutionContext.getJobDetail().getJobDataMap().get("group").toString();
            String name = jobExecutionContext.getJobDetail().getJobDataMap().get("name").toString();
            log.info("执行了task...group:{}, name:{}", group, name);
            String id = jobExecutionContext.getJobDetail().getKey().getName();
            testService.run(id);
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
