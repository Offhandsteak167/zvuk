var sqlite3 = require('sqlite3').verbose();
var db = new sqlite3.Database(':memory:');

get_account_email = function (account_id) {
    db.run("SELECT email FROM accounts WHERE account_id = \'"+account_id+"\'", function(err, row) {
        return row.email;
    });
}
/**
db.serialize(function() {
    db.run("CREATE TABLE lorem (info TEXT)");

    var stmt = db.prepare("INSERT INTO lorem VALUES (?)");
    for (var i = 0; i < 10; i++) {
        stmt.run("Ipsum " + i);
    }
    stmt.finalize();

    db.each("SELECT rowid AS id, info FROM lorem", function(err, row) {
        console.log(row.id + ": " + row.info);
    });
});
 **/

db.close();