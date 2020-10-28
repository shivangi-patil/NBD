printjson(db.inventory.updateMany({"location.city": "Moscow"}, { $set: { "location.city": "Moskwa" } }, { upsert: true }))
