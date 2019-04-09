package main.site.userShow.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import main.site.userShow.service.userShowService;

import java.util.List;

public class userShowController extends Controller {
    private userShowService userService = userShowService.me;
    Record record = new Record();
    List<Record> userInfoList = null;
    public void getUserInfo(){

        try {
            // 根据用户名取得用户信息
            userInfoList = userService.getUserInfo(getSessionAttr("userAccount").toString());

        } catch (Exception e) {

            //异常

        }

        System.out.println(userInfoList);
        record.set("code",0);
        record.set("msg","\"\"");
        record.set("data",userInfoList);
        record.set("count",userInfoList.size());
        renderJson(record);
    }
//    public String getJsonData(List<Record> userInfoList){//将查询结果转化为json数据
//        String left = "[";
//        String Lmiddle = "";
//        String right = "]";
//
//        for(int i=0;i<userInfoList.size();i++){
//            Record userInfo = userInfoList.get(i);
//            System.out.println(userInfo);
//            String middle = "{userid:"+userInfo.getStr("user_id")+",username:"+userInfo.getStr("user_name")+",useridnumber:"+userInfo.getStr("user_idnumber")+",userphonenumber:"+userInfo.getStr("user_phonenumber")+"}";
//            //String middle = "{\"userid\":"+userInfo.getStr("user_id")+",\"username\":\""+userInfo.getStr("user_name")+"\",\"useridnumber\":"+userInfo.getStr("user_idnumber")+"}";
//            System.out.println(middle);
//            String Nmiddle =null;
//            if((i+1)<userInfoList.size()){
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

}
