package com.bee.inodemonitor;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.AgentFactory;
import com.newrelic.metrics.publish.configuration.ConfigurationException;

import java.util.Map;

public class InodeAgentFactory extends AgentFactory {
    @Override
    public Agent createConfiguredAgent(Map<String, Object> map) throws ConfigurationException {
        String name = (String) map.get("name");
        String hostname = (String) map.get("hostname");
        String partitions = (String) map.get("partitions");

        if (name == null) {
            throw new ConfigurationException("'name' cannot be null. Do you have a 'config/plugin.json' file?");
        }

        return new InodeAgent(name);
    }
}
