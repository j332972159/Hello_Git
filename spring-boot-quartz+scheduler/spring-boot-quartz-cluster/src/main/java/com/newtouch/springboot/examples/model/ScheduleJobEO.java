package com.newtouch.springboot.examples.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_schedule_job")
@Entity
public class ScheduleJobEO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 任务group名称
    @Column(name = "group_name")
    private String groupName;

    // 任务job名称
    @Column(name = "job_name")
    private String jobName;

    // cron表达式
    private String cron;

    // 0 - 代表正在执行  1 - 已删除  2 - 暂停
    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "modified_time")
    private Long modifiedTime;
}