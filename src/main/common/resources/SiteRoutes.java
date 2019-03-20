package main.common.resources;

import com.jfinal.config.Routes;
import main.site.login.controller.LoginController;

public class SiteRoutes extends Routes {
    @Override
    public void config() {
        add("/login",LoginController.class,"");
    }
}
