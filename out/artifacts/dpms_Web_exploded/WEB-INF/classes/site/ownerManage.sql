#sql("getOwnerInfo")
select u.user_name,u.user_idnumber,u.user_phonenumber from user_info u,user_role_relation ur where  u.user_name = ? and ur.role_id = '3'and u.user_id = ur.user_id
#end