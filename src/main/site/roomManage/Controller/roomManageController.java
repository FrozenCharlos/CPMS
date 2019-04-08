package main.site.roomManage.Controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import main.site.roomManage.Service.roomManageService;

import java.util.List;

public class roomManageController extends Controller {
    private roomManageService roomService = roomManageService.me;
    public void getDefaultRoomMessage(){
        Record record = new Record();
        List<Record> userInfoList = null;
        try {
            // 根据用户名取得用户信息
            userInfoList = roomService.getAllRoomInfo();

        } catch (Exception e) {

            //异常
            e.printStackTrace();
            record.set("code", 1);
            record.set("msg", "登录异常");
            renderJson(record);
            return;
        }
    }
}
