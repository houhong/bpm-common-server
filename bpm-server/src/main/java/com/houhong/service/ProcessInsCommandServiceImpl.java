package com.houhong.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: bpm-starter
 * @description: 流程实列处理
 * @author: houhong
 * @create: 2022-07-17 21:53
 **/
@Service
public class ProcessInsCommandServiceImpl {


    @Autowired
    private RuntimeService runtimeService;


    public void modfiyProcessInsActity(String proceesIns, String actitiveId, String targetActivityId) {




        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(proceesIns)
                .singleResult();

        runtimeService.createProcessInstanceModification(processInstance.getId())
                .startBeforeActivity(actitiveId)
                .cancelAllForActivity(targetActivityId)
                .execute();

    }

}