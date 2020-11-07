db.inventory.mapReduce(
    function () {
        var key = this.sex;
        var value = {
            weight: +this.weight,
            height: +this.height,
            count: 1
        };

        emit( key, value );
    },
    function (key, values) {
        var tempReducedVal = { count: 0, totalWeight: 0, totalHeight: 0 };

        for (var idx = 0; idx < values.length; idx++) {
            tempReducedVal.count += values[idx].count;
            tempReducedVal.totalWeight += values[idx].weight;
            tempReducedVal.totalHeight += values[idx].height;
        }

        var reducedVal = {};
        reducedVal.avgWeight = tempReducedVal.totalWeight / tempReducedVal.count;
        reducedVal.avgHeight = tempReducedVal.totalHeight / tempReducedVal.count;

        return reducedVal;
    },
    {
        out: "avg_weight_height"
    }
)
printjson(db.avg_weight_height.find().toArray())
