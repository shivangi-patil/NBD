printjson(db.inventory.aggregate([
              { $match: {} },
              { $group: {
                  _id: "$sex",
                  avgWeight: { $avg: { $toDouble: "$weight" } },
                  avgHeight: { $avg: { $toDouble: "$height" } }
              } }
          ]).toArray())
