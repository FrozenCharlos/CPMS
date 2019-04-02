package main.common.resource;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;
import main.common.interceptor.ContextInterceptor;
import main.common.interceptor.SessionInter;
import main.common.util.User;
import main.site.login.interceptor.SiteAuthInterceptor;



//引导式配置
public class SiteConfig extends JFinalConfig {

    //配置常量
    public void configConstant(Constants constants) {
        loadPropertyFile("db_config.properties");
        constants.setDevMode(getPropertyToBoolean("devMode", true));
    }

    //配置路由
    public void configRoute(Routes routes) {

        //配置网站路由
        routes.add(new SiteRoutes());
    }

    public void configEngine(Engine engine) {
        engine.setDevMode(true);
    }

    //配置插件
    public void configPlugin(Plugins plugins) {

        // 配置C3p0数据库连接池插件
        C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim(),getProperty("driver"));
        plugins.add(c3p0Plugin);

        //配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);

        //支持多数据库
        arp.setDialect(new MysqlDialect());

        //让 ActiveRecord 对属性名（字段名）的大小写不敏感可以通过设置 CaseInsensitiveContainerFactory 来达到
        arp.setContainerFactory(new CaseInsensitiveContainerFactory());

        //设置数据库事务级别---8是针对oracle mysql设置成4
        arp.setTransactionLevel(4);
        arp.setShowSql(true);
        arp.setDevMode(true);

        //配置sql模板
        arp.setBaseSqlTemplatePath("/site");
        arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
        arp.addSqlTemplate("all.sql");//找不到all.sql  why?  已解决，加上上一行代码即可

        //model的映射
        arp.addMapping("user_info", User.class);
        plugins.add(arp);
    }

    //配置全局拦截器
    public void configInterceptor(Interceptors interceptors) {


        //系统路径拦截器
        //interceptors.addGlobalActionInterceptor(new ContextInterceptor());

        //权限控制拦截器，拦截请求判断相关请求权限
        interceptors.add(new SiteAuthInterceptor());

        //SessionInter 拦截获取请求中的session信息，使开发者在任何地方获取userid信息
        interceptors.add(new SessionInter());

        //页面可以通过#(session.value)获取session的值
        interceptors.add(new SessionInViewInterceptor());

    }


    //配置处理器
    public void configHandler(Handlers handlers) {
        //配置路径处理，可在页面使用#(ctx)取得
        handlers.add(new ContextPathHandler("ctx"));
    }
    //开始运行整个程序的主函数
    public static void main(String[] args) {
        JFinal.start("WebRoot", 8080, "/", 5);
    }
}
