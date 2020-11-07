printjson(db.inventory.aggregate([
              { $match: {sex: "Female", nationality: "Poland"} },
              { $unwind: "$credit" },
              { $group: {
                  _id: "$credit.currency",
                  totalBalance: { $sum: { $toDouble: "$credit.balance" } },
                  avgBalance: { $avg: { $toDouble: "$credit.balance" } }
              } }
          ]).toArray())
