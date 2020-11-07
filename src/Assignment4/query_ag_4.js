printjson(db.inventory.aggregate([
              { $match: {} },
              { $group: {
                  _id: "$nationality",
                  avgBMI: { $avg: { $divide: [{ $toDouble: "$weight" }, { $pow: [{ $toDouble: "$height" }, 2] }] } },
                  minBMI: { $min: { $divide: [{ $toDouble: "$weight" }, { $pow: [{ $toDouble: "$height" }, 2] }] } },
                  maxBMI: { $max: { $divide: [{ $toDouble: "$weight" }, { $pow: [{ $toDouble: "$height" }, 2] }] } }
              } }
          ]).toArray())
