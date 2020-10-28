printjson(db.inventory.find({"weight": {$gte:"68",$lte:"71.5"}}).toArray())
