#sql("getRoomInfoById")
select r.room_id,r.area,b.building_name,u.user_name,u.user_idnumber from room_info r,building_info b,user_info u where r.room_id = ? and b.building_id = r.building_id and u.user_id = r.owner_id
#end
#sql("getRoomInfoByOwner")
select r.room_id,r.area,b.building_name from room_info r,building_info b where  and b.building_id = r.building_id and r.owner_id = ?
#end
#sql("getAllRoomInfo")
select r.room_id,r.area,b.building_name,u.user_name,u.user_idnumber from building_info b,room_info r LEFT JOIN user_info u on   u.user_id = r.owner_id where b.building_id = r.building_id
#end

