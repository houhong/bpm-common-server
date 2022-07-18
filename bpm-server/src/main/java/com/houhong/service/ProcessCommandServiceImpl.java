package com.houhong.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: bpm-starter
 * @description: 流程定义命令服务
 * @author: houhong
 * @create: 2022-07-17 09:19
 **/
@Service
public class ProcessCommandServiceImpl {

    /**
     * 操作流程实列
     **/
    @Autowired
    private RuntimeService runtimeService;


    /**
     * @param processDefKey 流程定义key
     * @return
     * @Author houhong
     * @Description //TODO 从流程开始的processDefKey 开始开启
     * @Date 9:30 上午 2022/7/17
     **/
    public void startProcessFromStartBlankEvent(String processDefKey) {

        /**
         *
         *  流程变量从属于一个流程实列的所有任务
         *  当流程实列进入等待的时候，会自动会持久到
         *  数据库
         *
         **/
        Map<String, Object> variables = new HashMap<>();
        //使用prococessDefKey
        runtimeService.startProcessInstanceByKey(processDefKey, variables);

        //使用processId
        runtimeService.startProcessInstanceById(processDefKey);
    }


    /**
     * @param processDefKey
     * @return
     * @Author houhong
     * @Description //TODO 在任意一组活动中启动流程
     * @Date 9:34 上午 2022/7/17
     **/
    public void startProcessByTask(String processDefKey, List<String> taskDefSet) {

        runtimeService.createProcessInstanceByKey(processDefKey)
                .startBeforeActivity(taskDefSet.get(0))
                .setVariable("cure", "sadsd")
                .startBeforeActivity("sds")
                .setVariableLocal("dsdsd", "sads")
                .executeWithVariablesInReturn();//使用流程的最新方法

    }


    /**
     * 与流程实列交互
     * 1：触发它 （通过消息事件或者信号事件）
     * 2：取消它
     * 3： 开始取消任何活动
     **/
    public void chancelProcessIns(String processId, String reason) {

        runtimeService.deleteProcessInstance(processId, reason);

    }

    /**
     *
     *  挂起流程
     *
     **/

}