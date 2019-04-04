package main.site.index.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import main.common.interceptor.ContextInterceptor;
import main.common.interceptor.SessionInter;
import main.site.index.service.IndexService;
import main.site.login.interceptor.SiteAuthInterceptor;

import javax.servlet.http.HttpSession;

public class IndexController extends Controller {
    public void index(){
        render("index.html");
    }
    private IndexService indexService = IndexService.me;
}
