package main.site.login.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import javax.servlet.http.HttpSession;

//登录认证拦截器
public class SiteAuthInterceptor implements Interceptor {

    //拦截请求跳转登录方法
    @Override
    public void intercept(Invocation invocation) {
        //获取session
        HttpSession session = invocation.getController().getSession();

        //若session为空
        if(session == null){
            invocation.getController().redirect("/login");
        }
        else{
            String userAccount = (String) session.getAttribute("userAccount");
            String userName = (String) session.getAttribute("userName");

            //session验证成功
            if(userName != null&&userAccount !=null) {
                invocation.invoke();
            }
            else {
                //将原请求路径放入session
                session.setAttribute("redirect", invocation.getControllerKey());
                //重定向至登录页面
                invocation.getController().redirect("/login");
            }
        }
    }
}
