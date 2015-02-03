app = angular.module('smart',['ui.bootstrap', 'conteudo']);

app.controller('EquipmentQueryCtrl',['$scope', '$http', function($scope, $http){
	$scope.equipments = [];
	
	$scope.loadEquipments = function(){
		$http.get('rest/v1/equip/').
		  success(function(data, status, headers, config) {
		    $scope.equipments = data;
		  }).
		  error(function(data, status, headers, config) {
		    console.log(status + ' - ' + data);
		  });
	}

	$scope.$on('loadEquipmentList', function(e){
		$scope.loadEquipments();
	});
	
	$scope.show = function(equip){
		if(!equip.show){
			equip.show=true;
			$scope.loadCapabilities(equip);
		} else {
			equip.show=false;
		}
	}
	
	$scope.loadCapabilities =  function(equip){
		$http.get('rest/v1/equip/' + equip.id + '/capability/').
		  success(function(data, status, headers, config) {
		    equip.capabilities = data;
		  }).
		  error(function(data, status, headers, config) {
		    console.log(status + ' - ' + data);
		  });
	}
	
	$scope.loadEquipments();
	
}]);

app.controller('EquipmentManagerCtrl', ['$scope', '$http', '$rootScope', function($scope, $http, $rootScope){
	$scope.resetNewEquip = function(){
		$scope.newEquip= {
			id:''
		}
	}
	
	$scope.save = function(){
		$http.post('rest/v1/equip/',$scope.newEquip).success(function(data, status){
			$rootScope.$broadcast('loadEquipmentList');

			$rootScope.actionModel='List';
		});
		$scope.resetNewEquip();
	}
	
	$scope.resetNewEquip();
}]);

