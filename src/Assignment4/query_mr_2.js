db.inventory.mapReduce(
    function () {
        this.credit.forEach(function (account) {
           emit( account.currency, +account.balance );
        });
    },
    function (key, balancesVals) {
        return Array.sum(balancesVals);
    },
    {
        out: "total_balance"
    }
)
printjson(db.total_balance.find().toArray())
