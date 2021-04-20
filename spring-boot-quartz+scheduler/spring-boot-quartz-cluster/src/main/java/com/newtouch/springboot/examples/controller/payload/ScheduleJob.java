package com.newtouch.springboot.examples.controller.payload;

import lombok.Data;

@Data
public class ScheduleJob {
    private Integer id;
    private String groupName;
    private String jobName;
    private String cron;
}
