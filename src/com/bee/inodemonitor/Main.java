package com.bee.inodemonitor;

import com.newrelic.metrics.publish.Runner;
import com.newrelic.metrics.publish.util.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(InodeAgent.class);

    public static void main(String[] args) {
        try{
            Runner runner = new Runner();
            runner.add(new InodeAgentFactory());
            runner.setupAndRun();
        }catch (Exception e){
            logger.error(e,"error!");
            System.exit(-1);
        }
    }



//    public static String getInodeUsageOf(String partition) throws IOException, InterruptedException {
//
//        String cmd = "df -ih " + partition;
//        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        String line = "";
//        String value = "";
//        while ((line=buf.readLine()) != null) {
//            String[] strArray =  line.split(" ");
//            int len = strArray.length;
//            if (strArray[len - 2].equals("Mounted")){
//                continue;
//            }
//            String usageWithPercentage = strArray[len - 2];
//            if(usageWithPercentage.contains("%")){
//                value = usageWithPercentage.replace("%","");
//            }
//        }
//        return value;
//    }


}
