#sql("getRoomInfoById")
select r.room_id,r.area from room_info r,building_info b where r.room_id = ? and b.building_id = r.building_id and b.building_name = ?
#end
#sql("getRoomInfoByOwner")
select r.room_id,r.area,b.building_name from room_info r,building_info b where  and b.building_id = r.building_id and r.owner_id = ?
#end
#sql("getAllRoomInfo")
select * from room_info r,building_info b where  b.building_id = r.building_id
#end
