var app2 = angular.module('conteudo',[]);

app2.controller('MaterialCtrl',['$scope', function($scope){
	$scope.a={nome:"Abc"}
	$scope.escrever = function(){
		console.log('Material Control')
	}
}])

app2.directive('material',function(){
	return {
		template:'/material.html'
	};
})