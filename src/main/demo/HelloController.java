package main.demo;
import com.jfinal.core.Controller;

public class HelloController extends Controller {
    HelloController me=new HelloController();
    public void index()
    {
        render("hello.html");
        //renderText("Hello JFinal World.");
    }
}