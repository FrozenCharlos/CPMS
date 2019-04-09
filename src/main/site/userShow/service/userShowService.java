package main.site.userShow.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class userShowService {
    public  final static userShowService me = new userShowService();
    //根据用户名取得用户信息

    public static List<Record> getUserInfo(String userAccount) {

        //定义返回列表
        List<Record> recordList =null;

        //调用数据库namespace中的getUserInfo指令
        String sql = Db.getSql("userShow.getUserInfo");

        //执行sql语句在数据库中查找对应结果赋值给recordList
        recordList = Db.find(sql, userAccount);

        //返回结果值
        return recordList;
    }
    public List<Record> getUserRole(String userAccount) {

        //定义返回列表
        List<Record> recordList =null;
        String sql = Db.getSql("login.getUserRole");
        recordList = Db.find(sql, userAccount);
        return recordList;
    }
}

