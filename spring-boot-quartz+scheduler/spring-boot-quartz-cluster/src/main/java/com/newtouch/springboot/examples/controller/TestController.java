package com.newtouch.springboot.examples.controller;

import com.newtouch.springboot.examples.controller.payload.ScheduleJob;
import com.newtouch.springboot.examples.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 开启
     *
     * @param model
     * @return
     */
    @PostMapping("start")
    public String startSchedule(@RequestBody ScheduleJob model) {
        scheduleJobService.startSchedule(model);
        return "ok";
    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    @PostMapping("update")
    public String scheduleUpdateCorn(@RequestBody ScheduleJob model) {
        scheduleJobService.scheduleUpdateCorn(model);
        return "ok";
    }

    /**
     * 暂停
     *
     * @param model
     * @return
     */
    @PostMapping("/pause")
    public String schedulePause(@RequestBody ScheduleJob model) {
        scheduleJobService.schedulePause(model);
        return "ok";
    }

    /**
     * 恢复
     *
     * @param model
     * @return
     */
    @PostMapping("/resume")
    public String scheduleResume(@RequestBody ScheduleJob model) {
        scheduleJobService.scheduleResume(model);
        return "ok";
    }

    /**
     * 删除一个定时任务
     *
     * @param model
     * @return
     */
    @PostMapping("/delete")
    public String scheduleDelete(@RequestBody ScheduleJob model) {
        scheduleJobService.scheduleDelete(model);
        return "ok";
    }

    /**
     * 删除所有定时任务
     *
     * @param model
     * @return
     */
    @PostMapping("deleteAll")
    public String scheduleDeleteAll(@RequestBody ScheduleJob model) {
        scheduleJobService.scheduleDeleteAll();
        return "ok";
    }
}
