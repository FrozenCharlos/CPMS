package main.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.kit.StrKit;
import main.common.util.SessionKit;

public class SessionInter implements Interceptor {
    public void intercept(Invocation inv) {
//		    String userid = inv.getController().getPara("myuserId");
//			if(StrKit.notBlank(userid)){
//				inv.getController().setSessionAttr("userId", userid);
//			}
        SessionKit.set(inv.getController().getSession(true));
        try {
            inv.invoke();
        }
        finally {
            SessionKit.remove();
        }

    }
}