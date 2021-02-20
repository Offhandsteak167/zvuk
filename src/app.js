/*

GEREKLİ PAKETLER YÜKLENİYOR...

*/
var http = require('http');
var express = require('express');

var app = express();

app.set('port', process.env.PORT || 8080); // port to use
app.set('views', __dirname + '/app/server/views'); // view folder
app.set('view engine', 'ejs'); // VIEW ENGINE
app.use(express.static(__dirname + '/app/public')); // resource location

require('./app/routes')(app); // app routes

/*

HTTP SERVER OLUŞTURULDU

*/
http.createServer(app).listen(app.get('port'), function(){
});
