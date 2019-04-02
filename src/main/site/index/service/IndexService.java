package main.site.index.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class IndexService {
    public  final static IndexService me = new IndexService();
    public static List<Record> getUserInfo(String userAccount) {

        //定义返回列表
        List<Record> recordList =null;

        //调用数据库namespace中的getTestInfo指令
        String sql = Db.getSql("login.getUserInfo");

        //执行sql语句在数据库中查找对应结果赋值给recordList
        recordList = Db.find(sql, userAccount);

        //返回结果值
        return recordList;
    }
}
