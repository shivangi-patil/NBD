printjson(db.inventory.updateMany({"job": "Editor"}, { $unset: { "email": "" } }, { upsert : true}))
