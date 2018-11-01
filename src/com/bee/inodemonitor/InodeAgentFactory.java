package com.bee.inodemonitor;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.AgentFactory;
import com.newrelic.metrics.publish.configuration.ConfigurationException;

import java.util.Map;

public class InodeAgentFactory extends AgentFactory {
    @Override
    public Agent createConfiguredAgent(Map<String, Object> map) throws ConfigurationException {
        return null;
    }
}
