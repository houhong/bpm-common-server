package com.houhong.bpmbootsamples.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @program: bpm-starter
 * @description: 保险资格校验
 * @author: houhong
 * @create: 2022-07-20 21:41
 **/
@Component(value = "qulificationChecker")
public class QulificationChecker implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String isQualifidType = "no";

        delegateExecution.setVariable("isQualifid", isQualifidType);
    }
}