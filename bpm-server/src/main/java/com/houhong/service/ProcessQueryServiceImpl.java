package com.houhong.service;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ActivityInstance;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bpm-starter
 * @description: 流程定义查询服务
 * @author: houhong
 * @create: 2022-07-17 09:12
 **/
@Service
public class ProcessQueryServiceImpl {

    /**
     * 操作流程定义
     **/
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 操作任务
     **/
    @Autowired
    private TaskService taskService;


    /**
     * 操作流程实列
     **/
    @Autowired
    private RuntimeService runtimeService;


    /**
     * @param processDefKey 流程定义key
     * @return {@link List<ProcessDefinition>}
     * @Author houhong
     * @Description //TODO  根据流程定义key，获取所有的结果
     * @Date 9:16 上午 2022/7/17
     **/
    public List<ProcessDefinition> getProcessDefByDefKey(String processDefKey) {

        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processDefKey)
                .orderByProcessDefinitionVersion()
                .asc()
                .list();

        return processDefinitionList;
    }

    /**
     * @param processDefKey 流程定义key
     * @return {@link List<ProcessInstance>}
     * @Author houhong
     * @Description //TODO  根据流程定义key，获取当前正在运行的所有流程实列定列
     * @Date 9:16 上午 2022/7/17
     **/
    public List<ProcessInstance> getProcessDefByDefKey(String processDefKey, String editor) {

        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(processDefKey)
                // 选择创建者为 editor 的人
                .variableValueEquals("creditor", editor)
                .list();

        return processInstances;
    }


    /**
     * @param processInsId
     * @return {@link List<Execution>}
     * @Author houhong
     * @Description //TODO  根据proceeId获取所有执行
     * @Date 9:55 上午 2022/7/17
     **/
    public List<Execution> getExecuteList(String processInsId) {

        List<Execution> executions = runtimeService.createExecutionQuery()
                .processInstanceId(processInsId)
                .list();


        return executions;

    }

    /**
     * @param processId
     * @return {@link ActivityInstance}
     * @Author houhong
     * @Description //TODO 检索活动实列
     * @Date 10:24 上午 2022/7/17
     **/
    public ActivityInstance getActivitiyInsByProcessId(String processId) {

        ActivityInstance instance = runtimeService.getActivityInstance(processId);

        return instance;
    }


}