#sql("getBuildingInfo")
select building_id,building_name,building_level,building_height,building_type,building_status from building_info where building_id = ?
#end