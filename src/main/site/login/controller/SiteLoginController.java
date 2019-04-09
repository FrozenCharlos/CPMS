package main.site.login.controller;

import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.kit.HashKit;
import com.jfinal.plugin.activerecord.Record;
import main.site.login.interceptor.SiteAuthInterceptor;
import main.site.login.service.SiteLoginService;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SiteLoginController extends Controller {
    private SiteLoginService loginService = SiteLoginService.me;

    @Clear
    public void index() {
        render("login.html");
    }

    @Clear
    public void getUserLogin() {
        Record record = new Record();


        //取得文本框中的useraccount和userpassword值
        String useraccount = getPara("useraccount");
        String userpassword = getPara("userpassword");


        List<Record> userInfoList = null;

        try {
            // 根据用户名取得用户信息
            userInfoList = loginService.getUserInfo(useraccount);

        } catch (Exception e) {

            //异常
            e.printStackTrace();
            record.set("code", 1);
            record.set("msg", "登录异常");
            renderJson(record);
            return;
        }
        if (userInfoList == null || userInfoList.isEmpty()) {
            record.set("code", 1);
            record.set("msg", "用户不存在");
            renderJson(record);
            return;
        } else {
            Record userInfo = userInfoList.get(0);

            if (!userpassword.equals(userInfo.getStr("user_password"))) {
                record.set("code", 1);
                record.set("msg", "密码错误");
                renderJson(record);
                return;
            }
            List<Record> userRoleList = null;
            try {
                // 根据用户名取得角色信息
                userRoleList = loginService.getUserRole(useraccount);
            } catch (Exception e) {
                e.printStackTrace();
                record.set("code", 1);
                record.set("msg", "查询角色信息错误");
                renderJson(record);
                return;
            }
            if (userRoleList == null || userRoleList.isEmpty()) {
                record.set("code", 1);
                record.set("msg", "用户角色信息不存在");
                renderJson(record);
                return;
            }

            Record userRole = userRoleList.get(0);

            //用户信息录入至session
            setSessionAttr("userAccount", useraccount);
            setSessionAttr("userName", userInfo.getStr("user_name"));
            setSessionAttr("userId", userInfo.getStr("user_id"));
            setSessionAttr("userType", userRole.getStr("role_id"));
            setSessionAttr("userRole", userRole.getStr("role_name"));
            String redirectUrl = this.getSessionAttr("redirect");


            record.set("code",0);
            String redirect=null;

            if(redirectUrl == null || redirectUrl.equals("/login")){
                redirect="index";
                record.set("msg",redirect);
                renderJson(record);
                return;
            }
            else{
                //重定向到原始请求路径
                redirect=redirectUrl.replaceFirst("/", "");
                getSession().removeAttribute("redirect");
                record.set("msg",redirect);
                renderJson(record);
                return;
            }
        }
    }

    //用户登出
    @Clear
    public void getUserLogout() {
        HttpSession session = getSession();
        if(session == null || session.getAttribute("userType") == null) {
            //重定向到登录页
            //render("login.html");
            redirect("/login");
            return;
        }

        //清除session中的信息
        session.removeAttribute("userAccount");
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        session.removeAttribute("userType");
        session.removeAttribute("userRole");
//        render("login.html");
        redirect("/login");
    }
}
