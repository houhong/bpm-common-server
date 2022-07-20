package com.houhong.bpmbootsamples.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @program: bpm-starter
 * @description: 保险完整校验
 * @author: houhong
 * @create: 2022-07-20 21:27
 **/
@Slf4j
@Component(value = "integrityChecker")
public class IntegrityChecker implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info("#开始检查保险的完整性#");

        boolean intergrityResult = checkRequestIntergrity(delegateExecution);
        log.info("#资料完整性结果:{}#", intergrityResult);

        delegateExecution.setVariable("isDocumentComplete", intergrityResult);

        if (!intergrityResult) {

            delegateExecution.setVariable("declineMessgae", "参保资料不完整，请核对相关文件");
        }

    }


    /**
     * @param delegateExecution
     * @return {@link boolean}
     * @Author houhong
     * @Description //TODO 校验完整性
     * @Date 9:32 下午 2022/7/20
     **/
    private boolean checkRequestIntergrity(DelegateExecution delegateExecution) {


        String id = (String) delegateExecution.getVariable("id");
        String name = (String) delegateExecution.getVariable("name");

        log.info("#id ={},name = {}#", id, name);

        return StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(name);

    }
}

