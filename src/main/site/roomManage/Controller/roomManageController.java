package main.site.roomManage.Controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import main.site.roomManage.Service.RoomManageService;

import java.util.List;

public class RoomManageController extends Controller {
    private RoomManageService roomService = RoomManageService.me;
    Record record = new Record();
    List<Record> roomInfoList = null;
    public void getAllRoomMessage(){

        try {
            // 取得所有房屋信息
            roomInfoList = roomService.getAllRoomInfo();

        } catch (Exception e) {

            //异常

        }
        //包装json数据
        record.set("code",0);
        record.set("msg","\"\"");
        record.set("data",roomInfoList);
        record.set("count",roomInfoList.size());
        renderJson(record);

        return ;
    }
//    public String getJsonData(List<Record> roomInfoList){//将查询结果转化为json数据
//        String left = "[";
//        String Lmiddle = "";
//        String right = "]";
//
//        for(int i=0;i<roomInfoList.size();i++){
//            Record roomInfo = roomInfoList.get(i);
//            System.out.println(roomInfo);
//            String middle = "{buildingName:"+roomInfo.getStr("building_name")+",roomId:"+roomInfo.getStr("room_id")+",roomArea:"+roomInfo.getStr("area")+"}";
//            //String middle = "{\"buildingName\":\""+roomInfo.getStr("building_name")+"\",\"roomId\":\""+roomInfo.getStr("room_id")+"\",\"roomArea\":"+roomInfo.getStr("area")+"}";
//            System.out.println(middle);
//            String Nmiddle =null;
//            if((i+1)<roomInfoList.size()){
//                Nmiddle = middle +",";
//            }
//            else{
//                Nmiddle = middle;
//            }
//            Lmiddle = Lmiddle + Nmiddle;
//            record.set("count",i+1);
//        }
//
//        return(left+Lmiddle+right);
//    }
    public void getRoomInfoById(){
        int id = Integer.parseInt(getPara("id"));
        //String buildingNama = getPara("");
        try {
            // 根据ID取得房屋信息
            roomInfoList = roomService.getRoomInfoById(id);

        } catch (Exception e) {

            //异常

        }
        //包装json数据
        record.set("code",0);
        record.set("msg","\"\"");
        record.set("data",roomInfoList);
        record.set("count",roomInfoList.size());
        renderJson(record);

        return ;

    }
}
