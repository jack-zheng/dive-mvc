package org.dive;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class P9Main {
    public static void main(String[] args) throws Exception {
        // 启动 Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        // 不能少，隐含了 connection 的初始化
        tomcat.getConnector();


        // 创建 web app，应为要使用 web.xml 所以必须配置 resource
        String projectPrefix = Utils.getProjectName() + "/";
        Context ctx = tomcat.addWebapp(
                "",
                new File(projectPrefix + "src/main/webapp").getAbsolutePath());
        WebResourceRoot resourceRoot = new StandardRoot(ctx);
        resourceRoot.addPreResources(
                new DirResourceSet(resourceRoot, "/WEB-INF/classes", new File(projectPrefix + "target/classes").getAbsolutePath(), "/")
        );
        ctx.setResources(resourceRoot);
        tomcat.start();
        tomcat.getServer().await();
    }
}
