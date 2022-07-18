package com.houhong.service.innerevent;

import org.camunda.bpm.engine.impl.incident.IncidentContext;
import org.camunda.bpm.engine.impl.incident.IncidentHandler;
import org.camunda.bpm.engine.runtime.Incident;
import org.springframework.stereotype.Component;

/**
 * @program: bpm-starter
 * @description: camunda 内部错误事件处理器
 * @author: houhong
 * @create: 2022-07-18 00:18
 **/
@Component
public class ErrorEventHandler implements IncidentHandler {

    /**
     * Returns the incident type this handler activates for.
     */
    @Override
    public String getIncidentHandlerType() {
        return null;
    }

    /**
     * Handle an incident that arose in the context of an execution.
     *  创建新事件调用
     *
     * @param context
     * @param message
     */
    @Override
    public Incident handleIncident(IncidentContext context, String message) {
        return null;
    }

    /**
     * Called in situations in which an incidenthandler may wich to resolve existing incidents
     * The implementation receives this callback to enable it to resolve any open incidents that
     * may exist.
     *   事件被解决
     *
     * @param context
     */
    @Override
    public void resolveIncident(IncidentContext context) {

    }

    /**
     * Called in situations in which an incidenthandler may wich to delete existing incidents
     * Example: when a scope is ended or a job is deleted. The implementation receives
     * this callback to enable it to delete any open incidents that may exist.
     *
     * @param context
     */
    @Override
    public void deleteIncident(IncidentContext context) {

    }
}