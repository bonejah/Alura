var mysql = require('mysql');

/*
// Factory Method
function createDBConnection(){
	return mysql.createConnection({
		host: 'localhost',
		user: 'root',
		password: 'admin',
		database: 'casadocodigo_nodejs' 
	});
}		
// wrapper	
module.exports = function(){
	return createDBConnection;
}
*/

function createDBConnection(){
	if(!process.env.NODE_ENV || process.env.node === 'dev') {
		return mysql.createConnection({
			host: 'localhost',
			user: 'root',
			password: 'admin',
			database: 'casadocodigo_nodejs' 
		});
	}

	if(process.env.NODE_ENV === 'test') {
		return mysql.createConnection({
			host: 'localhost',
			user: 'root',
			password: 'admin',
			database: 'casadocodigo_nodejs_teste' 
		});
	}
}

module.exports = function(){
	return createDBConnection;
}