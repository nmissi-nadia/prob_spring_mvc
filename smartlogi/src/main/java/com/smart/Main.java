package com.smart;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        Context context = tomcat.addContext("", System.getProperty("java.io.tmpdir"));

        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("classpath:applicationContext-core.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        var servletWrapper = Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        servletWrapper.setLoadOnStartup(1);
        context.addServletMappingDecoded("/api/*", "dispatcher"); // toutes les requêtes passent par Spring

        tomcat.start();
        tomcat.getServer().await();
    }
}
