package main.site.login.controller;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
    public void index(){
        render("login.html");
    }
}
