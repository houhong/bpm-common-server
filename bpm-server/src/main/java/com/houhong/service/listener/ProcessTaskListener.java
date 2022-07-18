package com.houhong.service.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.cfg.IdGenerator;
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: bpm-starter
 * @description: 流程实列任务监听器
 * @author: houhong
 * @create: 2022-07-17 22:17
 **/
@Component
public class ProcessTaskListener implements TaskListener {

    @Autowired
    List<IdGenerator> idGeneratorList;


    @Override
    public void notify(DelegateTask delegateTask) {


    }

    public static void main(String[] args) {

        

        //Id生成器
        StrongUuidGenerator strongUuidGenerator = new StrongUuidGenerator();

        String nextId = strongUuidGenerator.getNextId();
        System.out.println(nextId);
    }
}