#sql("getUserInfoByName")
select user_account,user_password,user_name,user_id,user_idnumber,user_phonenumber from user_info where user_name = ?
#end
#sql("getUserInfoByAccount")
select user_account,user_password,user_name,user_id,user_idnumber,user_phonenumber from user_info where user_account = ?
#end
#sql("getUserInfoById")
select user_account,user_password,user_name,user_id,user_idnumber,user_phonenumber from user_info where user_id = ?
#end
