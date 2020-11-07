db.inventory.mapReduce(
    function () {
        this.credit.forEach(function (account) {
           emit( account.currency, +account.balance );
        });
    },
    function (key, balancesVals) {
        var reducedVal = {};

        reducedVal.totalBalance = Array.sum(balancesVals);
        reducedVal.avgBalance = reducedVal.totalBalance / balancesVals.length;

        return reducedVal;
    },
    {
        query: {sex: "Female", nationality: "Poland"},
        out: "polish_balance"
    }
)
printjson(db.polish_balance.find().toArray())
