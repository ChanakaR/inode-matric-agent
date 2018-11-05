package com.bee.inodemonitor;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.util.Logger;

import java.io.IOException;

public class InodeAgent extends Agent {
    private static final String GUID = "com.bee.INodeWatcher";
    private static final String VERSION = "1.0.0";
    private String name = "";
    private InodeMonitor inodeMonitor = new InodeMonitor();

    private static final Logger logger = Logger.getLogger(InodeAgent.class);

    public InodeAgent(String name){
        super(GUID, VERSION);
        this.name = name;
    }

    @Override
    public void pollCycle() {
        try {
            String value = this.inodeMonitor.getInodeUsageOf("/");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reportMetric("INode/Usage", "count", 10);
    }

    @Override
    public String getAgentName() {
        return this.name;
    }
}
