package com.houhong.bpmbootsamples.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @program: bpm-starter
 * @description: 拒保通知
 * @author: houhong
 * @create: 2022-07-20 21:58
 **/
@Component(value = "declineInsuranceDeleagte")
public class DeclineInsuranceDeleagte implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String parePareMessgae = parepareRejectMessage();

        delegateExecution.setVariable("declineMessage", parePareMessgae);
    }

    public String parepareRejectMessage() {


        return "抱歉，保险被拒绝，请联系人工客服";

    }
}