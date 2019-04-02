package main.common.util;

import javax.servlet.http.HttpSession;

public class SessionKit {
    private static ThreadLocal<HttpSession> tl = new ThreadLocal<HttpSession>();

    public static void set(HttpSession s) {
        tl.set(s);
    }

    public static HttpSession get() {
        return tl.get();
    }

    public static void remove() {
        tl.remove();
    }
}
