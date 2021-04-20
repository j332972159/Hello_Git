package com.newtouch.springboot.examples.service;

import com.newtouch.springboot.examples.controller.payload.ScheduleJob;

public interface ScheduleJobService {

    /**
     * 开启定时任务
     *
     * @param model
     */
    void startSchedule(ScheduleJob model);

    /**
     * 更新定时任务
     *
     * @param model
     */
    void scheduleUpdateCorn(ScheduleJob model);

    /**
     * 任务 - 暂停
     */
    void schedulePause(ScheduleJob model);

    /**
     * 任务 - 恢复
     */

    void scheduleResume(ScheduleJob model);

    /**
     * 任务 - 删除一个定时任务
     */
    void scheduleDelete(ScheduleJob model);

    /**
     * 删除所有定时任务
     */
    void scheduleDeleteAll();

}