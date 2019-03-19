package main.demo;
import com.jfinal.config.*;
import com.jfinal.template.Engine;
import main.demo.HelloController;

public class DemoConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }
    @Override
    public void configRoute(Routes routes) {
        routes.add(new PortalsiteRoutes());
        //routes.add("/hello",HelloController.class);
    }
    public class PortalsiteRoutes extends Routes {
        @Override
        public void config() {
        add("/hello",HelloController.class);
        }
    }
    @Override
    public void configEngine(Engine engine) {
    }
    @Override
    public void configPlugin(Plugins plugins) {
    }
    @Override
    public void configInterceptor(Interceptors interceptors) {
    }
    @Override
    public void configHandler(Handlers handlers) {
    }
}
