printjson(db.inventory.find({ "birth_date": { $gte: "2000-01-01T00:00:00Z" } }, { "first_name": 1, "last_name":1, "city": 1 }).toArray())
