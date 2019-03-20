package main.common.resources;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

public class SiteConfig extends JFinalConfig {


    public void configConstant(Constants constants) {

    }

    public void configRoute(Routes routes) {
        routes.add(new SiteRoutes());
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
    public static void main(String[] args) {
        JFinal.start("WebRoot", 8080, "/", 5);
    }
}
