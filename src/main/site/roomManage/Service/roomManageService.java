package main.site.roomManage.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class RoomManageService {
    public  final static RoomManageService me = new RoomManageService();
    public static List<Record> getAllRoomInfo() {

        //定义返回列表
        List<Record> recordList =null;

        //调用数据库namespace中的getAllRoomInfo指令
        String sql = Db.getSql("roomManage.getAllRoomInfo");

        //执行sql语句在数据库中查找对应结果赋值给recordList
        recordList = Db.find(sql);

        //返回结果值
        return recordList;
    }

    public static List<Record> getRoomInfoById(int roomId,String building_name) {

        //定义返回列表
        List<Record> recordList =null;

        //调用数据库namespace中的getRoomInfoById指令
        String sql = Db.getSql("roomManage.getRoomInfoById");

        //执行sql语句在数据库中查找对应结果赋值给recordList
        recordList = Db.find(sql, roomId,building_name);

        //返回结果值
        return recordList;
    }
}
