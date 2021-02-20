module.exports = function(app) {

    app.get('/',function(req,res){
        res.render('index');
    });

    app.get('/meeting',function(req,res){
        res.render('meeting');
    });
    app.get('/queue',function(req,res){
        res.render('call_queue');
    });
    app.get('/customer',function(req,res){
        res.render('customer_login');
    });
    app.get('/business',function(req,res){
        res.render('business_login');
    });
    app.get('/directory',function(req,res){
        res.render('business_directory');
    });

}