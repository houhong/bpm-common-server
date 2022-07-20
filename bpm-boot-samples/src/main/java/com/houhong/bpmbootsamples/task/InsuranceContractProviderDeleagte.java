package com.houhong.bpmbootsamples.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @program: bpm-starter
 * @description: 准备保单
 * @author: houhong
 * @create: 2022-07-20 22:14
 **/
@Slf4j
@Component(value = "insuranceContractProviderDeleagte")
public class InsuranceContractProviderDeleagte implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Long premium = (Long) execution.getVariable("premium");
        String message = parepareMessgae(premium);

        execution.setVariable("contractMessage", message);
        log.info("#准备保单#");
    }


    private String parepareMessgae(Long premium) {

        return "恭喜,参保成功，保单为:" + premium;

    }
}