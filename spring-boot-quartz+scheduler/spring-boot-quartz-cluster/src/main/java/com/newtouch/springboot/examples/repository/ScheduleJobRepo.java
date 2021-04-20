package com.newtouch.springboot.examples.repository;

import com.newtouch.springboot.examples.model.ScheduleJobEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobRepo extends JpaRepository<ScheduleJobEO, Integer>,
        JpaSpecificationExecutor<ScheduleJobEO> {
    ScheduleJobEO findByIdAndStatus(Integer id, Integer status);

    List<ScheduleJobEO> findAllByStatus(Integer status);

    List<ScheduleJobEO> findByGroupNameAndJobNameAndStatus(String groupName, String jobName, Integer status);

    List<ScheduleJobEO> findAllByStatusInOrderByCreateTimeDesc(List<Integer> statusList);
}