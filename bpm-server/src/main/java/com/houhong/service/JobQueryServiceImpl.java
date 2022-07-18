package com.houhong.service;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.management.JobDefinition;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.JobQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: bpm-starter
 * @description: bpm流程作业查询服务
 * @author: houhong
 * @create: 2022-07-17 10:26
 **/
@Service
public class JobQueryServiceImpl {

    @Autowired
    private ManagementService managementService;


    /**
     * @param processDefKey
     * @return {@link List<JobDefinition>} 返回所有的定时器和异步延续的信息
     * @Author houhong
     * @Description //TODO  根据流程定义key 获取任务定义
     * @Date 10:29 上午 2022/7/17
     **/
    public List<JobDefinition> geyJobDefByProcesDefKey(String processDefKey) {


        List<JobDefinition> jobDefinitions = managementService.createJobDefinitionQuery()
                .processDefinitionId(processDefKey)
                .list();


        return jobDefinitions;
    }


    /**
     * @param dueDate
     * @return {@link List<Job>}
     * @Author houhong
     * @Description //TODO 查询大于的时间
     * @Date 10:31 上午 2022/7/17
     **/
    public List<Job> geyJobByDueDate(Date dueDate) {


        List<Job> jobList = managementService.createJobQuery()
                .duedateHigherThan(dueDate)
                .list();


        return jobList;
    }


}