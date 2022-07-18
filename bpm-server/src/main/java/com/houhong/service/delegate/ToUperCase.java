package com.houhong.service.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @program: bpm-starter
 * @description: 修改变量由小写为大写
 * @author: houhong
 * @create: 2022-07-17 22:09
 **/
public class ToUperCase implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String value = (String) execution.getVariable("test");
        value = value.toUpperCase();
        execution.setVariable("test", value);
    }
}