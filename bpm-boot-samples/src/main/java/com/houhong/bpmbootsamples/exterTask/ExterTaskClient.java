package com.houhong.bpmbootsamples.exterTask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: bpm-starter
 * @description: 外部任务
 * @author: houhong
 * @create: 2022-07-20 22:45
 **/
@Slf4j
@Component
public class ExterTaskClient {


    @Autowired
    private ExternalTaskService externalTaskService;


    /**
     * @param topic    主题
     * @param workerId
     * @return
     * @Author houhong
     * @Description //TODO 外部任务客户端，订阅主题，获取任务然后消费他
     * @Date 10:55 下午 2022/7/20
     **/
    private void dealExternalTask(String workerId, String topic) {


        int maxTasks = 5;
        boolean usePriority = true;
        int lockDuratio = 1000 * 60 * 10;
        List<LockedExternalTask> lockedExternalTaskList = externalTaskService
                .fetchAndLock(maxTasks, workerId, usePriority)
                .topic(topic, lockDuratio)
                .execute();

        for (LockedExternalTask lockedExternalTask : lockedExternalTaskList) {
            System.out.println("#########");
            System.out.println(lockedExternalTask.getPriority());
            System.out.println(lockedExternalTask.getId());
            System.out.println(lockedExternalTask.getTopicName());
            System.out.println("#########");

        }

    }


    private void dealExternalTask(String workerId, String topic, int maxTasks) {


        boolean usePriority = true;
        int lockDuratio = 1000 * 60 * 10;
        List<LockedExternalTask> lockedExternalTaskList = externalTaskService
                .fetchAndLock(maxTasks, workerId, usePriority)
                .topic(topic, lockDuratio)
                .execute();

        for (LockedExternalTask lockedExternalTask : lockedExternalTaskList) {
            System.out.println("#########");
            System.out.println(lockedExternalTask.getPriority());
            System.out.println(lockedExternalTask.getId());
            System.out.println(lockedExternalTask.getTopicName());
            System.out.println("#########");

        }

    }

    private void dealExternalTask(String workerId, String topic, int maxTasks, boolean usePriority) {


        int lockDuratio = 1000 * 60 * 10;
        List<LockedExternalTask> lockedExternalTaskList = externalTaskService
                .fetchAndLock(maxTasks, workerId, usePriority)
                .topic(topic, lockDuratio)
                .execute();

        for (LockedExternalTask lockedExternalTask : lockedExternalTaskList) {
            System.out.println("#########");
            System.out.println(lockedExternalTask.getPriority());
            System.out.println(lockedExternalTask.getId());
            System.out.println(lockedExternalTask.getTopicName());
            System.out.println("#########");

        }

    }

    private void dealExternalTask(String workerId, String topic, int maxTasks, boolean usePriority, int lockDuratio) {


        List<LockedExternalTask> lockedExternalTaskList = externalTaskService
                .fetchAndLock(maxTasks, workerId, usePriority)
                .topic(topic, lockDuratio)
                .execute();

        for (LockedExternalTask lockedExternalTask : lockedExternalTaskList) {
            log.info("#########");
            log.info("#属性:{}#", lockedExternalTask.getPriority());
            log.info(lockedExternalTask.getId());
            log.info(lockedExternalTask.getTopicName());
            log.info("#########");

        }

    }

}
