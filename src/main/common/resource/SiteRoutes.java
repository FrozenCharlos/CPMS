package main.common.resource;

import com.jfinal.config.Routes;
import main.site.index.controller.IndexController;
import main.site.login.controller.SiteLoginController;
import main.site.roomManage.Controller.RoomManageController;
import main.site.userShow.controller.userShowController;

public class SiteRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/site/template");
        add("/login",SiteLoginController.class,"");
        add("/index",IndexController.class,"");
        add("/roomManage",RoomManageController.class,"");
        add("/userShow",userShowController.class,"");
    }
}
