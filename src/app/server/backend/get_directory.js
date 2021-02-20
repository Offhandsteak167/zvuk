var sqlite3 = require('sqlite3');
var db = new sqlite3.Database('./database.sqlite3');


function get_directory() {
    var directory = [];
    db.each("SELECT * FROM companies", function(err, row) {
        directory.push([row.col1, row.col2])
    });
    return directory;
}
