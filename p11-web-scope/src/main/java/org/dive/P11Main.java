package org.dive;

import org.apache.catalina.startup.Tomcat;

public class P11Main {
    public static void main(String[] args) throws Exception {
        // 启动 Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        // 不能少，隐含了 connection 的初始化
        tomcat.getConnector();

        tomcat.addWebapp("",
                Thread.currentThread().getContextClassLoader().getResource("").getPath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
