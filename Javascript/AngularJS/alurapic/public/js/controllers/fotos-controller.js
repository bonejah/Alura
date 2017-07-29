angular.module('alurapic').controller('FotosController', function($scope, recursoFoto){
	//var recursoFoto = $resource('/v1/fotos/:fotoId');

	$scope.fotos = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoFoto.query(function(fotos){
		 $scope.fotos = fotos;
	}, function(erro){
		console.log(erro);
	});

	/*
	$http.get('/v1/fotos')
    .success(function(retorno) {
        console.log(retorno);
        $scope.fotos = retorno; // não precisa fazer retorno.data
    })
    .error(function(erro) {
        console.log(erro);
    });
	*/

	$scope.remover = function(foto) {
		recursoFoto.delete({fotoId: foto._id}, function(){
			var indiceDaFoto = $scope.fotos.indexOf(foto);
    		$scope.fotos.splice(indiceDaFoto, 1);
    		$scope.mensagem = 'Foto ' + foto.titulo + ' removida com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a foto ' + foto.titulo;
		});

	}

	/*
    $scope.remover = function(foto) {
    	$http.delete('/v1/fotos/' + foto._id)
    	.success(function(){
    		//console.log('Foto ' + foto.titulo + ' removida com sucesso!');
    		var indiceDaFoto = $scope.fotos.indexOf(foto);
    		$scope.fotos.splice(indiceDaFoto, 1);
    		$scope.mensagem = 'Foto ' + foto.titulo + ' removida com sucesso!';
    	})
    	.error(function(error){
    		//console.log('Não foi possível apagar a foto ' + foto.titulo);	
    		$scope.mensagem = 'Não foi possível apagar a foto ' + foto.titulo;
    	});
    };
    */

	/* Omitindo o promise
	$http.get('/v1/fotos').then(function(retorno) {
		$scope.fotos = retorno.data;
	}).catch(function (error) {
		console.log(error);
	});
	*/

	/* Utilizando promise
	var promise = $http.get('/v1/fotos');
	
	promise.then(function(retorno){
		$scope.fotos = retorno.data;		
	})
	.catch(function error) {
		console.log(error);
	});
	*/
});