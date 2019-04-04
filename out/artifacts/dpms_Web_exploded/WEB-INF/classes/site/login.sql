#sql("getUserInfo")
select user_password,user_name,user_id from user_info where user_account = ?
#end

#sql("getUserRole")
select r.role_name,r.role_id from user_info u,user_role_relation urr,role_info r where u.user_id = urr.user_id and urr.role_id =r.role_id and  user_account = ?
#end