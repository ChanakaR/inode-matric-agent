package com.bee.inodemonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InodeMonitor {

    public String getInodeUsageOf(String partition) throws IOException, InterruptedException {

        String cmd = "df -ih " + partition;
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        String value = "";
        while ((line=buf.readLine()) != null) {
            String[] strArray =  line.split(" ");
            int len = strArray.length;
            if (strArray[len - 2].equals("Mounted")){
                continue;
            }
            String usageWithPercentage = strArray[len - 2];
            if(usageWithPercentage.contains("%")){
                value = usageWithPercentage.replace("%","");
            }
        }
        return value;
    }
}
