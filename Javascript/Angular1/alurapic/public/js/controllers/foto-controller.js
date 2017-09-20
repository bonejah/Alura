angular.module('alurapic')
    .controller('FotoController', function($scope, recursoFoto, $routeParams, cadastroDeFotos) {       
       /*
        var recursoFoto = $resource('/v1/fotos/:fotoId', null, {
            'update' : {
                method: 'PUT'
            }
        });
        */
        
      	$scope.foto = {};
        $scope.mensagem = '';

        if($routeParams.fotoId) {
            recursoFoto.get({fotoId: $routeParams.fotoId}, function(foto){
                $scope.foto = foto;
            }, function(erro) {
                 console.log(erro);
                $scope.mensagem = 'Não foi possível obter a foto';
            });
        }

        /*
        if($routeParams.fotoId) {
            $http.get('/v1/fotos/' + $routeParams.fotoId)
            .success(function(foto){
                $scope.foto = foto;
            })
            .error(function(erro){
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a foto';
            });
        }
        */

        $scope.submeter = function() {
            if($scope.formulario.$valid) {
                cadastroDeFotos.cadastrar($scope.foto)
                .then(function(dados){
                    $scope.mensagem = dados.mensagem;
                    if(dados.inclusao) $scope.foto = {};
                    //$scope.focado = true;
                    //$scope.$broadcast('fotoCadastrada');
                })
                .catch(function(erro){
                    $scope.mensagem = dados.mensagem;
                });
            }
        };

        /*
        $scope.submeter = function() {
            if ($scope.formulario.$valid) {
                if($routeParams.fotoId) {
                     // código omitido, ainda não tocamos nele!
                     recursoFoto.update({fotoId: $scope.foto._id},
                        $scope.foto, function(){
                            $scope.mensagem = 'Foto alterada com sucesso';
                        }, function(erro) {
                            console.log(erro);
                            $scope.mensagem = 'Não foi possível alterar a foto';
                        });

                } else {
                    // novidade aqui! Alterando apenas a inclusão!
                    recursoFoto.save($scope.foto, function() {
                        $scope.foto = {};
                        $scope.mensagem = 'Foto cadastrada com sucesso';
                    }, function(erro) {
                        console.log(erro);
                        $scope.mensagem = 'Não foi possível cadastrar a foto';
                    });
                }
            }
        };
        */

        /*
        $scope.submeter = function() {
        	if($scope.formulario.$valid) {
                if($routeParams.fotoId) {
                    $http.put('/v1/fotos/' + $scope.foto._id, $scope.foto)
                    .success(function(){
                        $scope.mensagem = 'Foto alterada com sucesso';
                    })
                    .error(function(erro){
                        console.log(erro);
                        $scope.mensagem = 'Não foi possível alterar a foto';
                    });
                } else {
                    $http.post('/v1/fotos', $scope.foto)
                    .success(function(){
                        $scope.mensagem = 'Foto adicionada com sucesso';
                    })
                    .error(function(erro) {
                        console.log(erro);
                        $scope.mensagem = 'Não foi possível cadastrar a foto';  
                    });
                }
        	}
        };
        */
    });

    