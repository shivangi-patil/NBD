printjson(db.inventory.updateMany({"first_name": "Antonio"}, { $set: { "hobby": "table tennis" } }, { upsert: true }))
