db.inventory.mapReduce(
    function () {
        var key = this.nationality;
        var value = {
            weight: +this.weight,
            height: +this.height,
            count: 1
        };

        emit( key, value );
    },
    function (key, values) {
        var tempReducedVal = { count: 0, totalBMI: 0 };
        var minBMI = getBMI(values[0].weight, values[0].height);
        var maxBMI = getBMI(values[0].weight, values[0].height);

        for (var idx = 0; idx < values.length; idx++) {
            var currentBMI = getBMI(values[idx].weight, values[idx].height);
            tempReducedVal.count += values[idx].count;
            tempReducedVal.totalBMI += currentBMI;

            if (currentBMI > maxBMI) {
                maxBMI = currentBMI;
            }
            if (currentBMI < minBMI) {
                minBMI = currentBMI;
            }
        }

        var reducedVal = {};
        reducedVal.avgBMI = tempReducedVal.totalBMI / tempReducedVal.count;
        reducedVal.minBMI = minBMI;
        reducedVal.maxBMI = maxBMI;

        return reducedVal;

        function getBMI(weight, height) {
            return weight / Math.pow(height, 2);
        }
    },
    {
        out: "nationalities_bmi"
    }
)
printjson(db.nationalities_bmi.find().toArray())
