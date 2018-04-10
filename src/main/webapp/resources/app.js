angular.module('recipemanager', []).
controller('recipemanagerController', function($scope, $timeout, $http) {
    console.log("Inside recipe manager controller");
       $scope.recipeForm = {};
       $scope.id = null;
       $scope.saveRecipe = function() {
       $http({
		  method  : 'POST',
		  url     : 'recipe',
		  data    : $scope.recipeForm,
	  	})
	    .success(function(data){
	    	$scope.recipeForm = data;
	    	setTimeout(function() {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                if($scope.recipeForm.messageType == "Success"){
                	toastr.success($scope.recipeForm.successOrErrorMessage);
                }else{
                	toastr.error($scope.recipeForm.successOrErrorMessage);
                }
            }, 1300);
	    });
      };
      
      $scope.getRecipe = function() {
    	$scope.id = $("#recipes").val();
        $http({
   		  method  : 'GET',
   		  url     : 'recipe/' + $scope.id,
   	  	})
   	    .success(function(data){
   	    	$scope.recipeForm = data;
   	    });
      };
      
      $scope.deleteRecipe = function() {
    	  $scope.id = $("#recipes").val();
    	  if($scope.id == ""){
    		  toastr.options = {
                      closeButton: true,
                      progressBar: true,
                      showMethod: 'slideDown',
                      timeOut: 4000
                  };
    		  	toastr.error("Please select a recipe");
    	  }else{
	      $http({
	 		  method  : 'DELETE',
	 		  url     : 'recipe/' + $scope.id,
	 	  	})
	 	    .success(function(data){
	 	    	$scope.recipeForm = data;
	 	    	toastr.options = {
	                    closeButton: true,
	                    progressBar: true,
	                    showMethod: 'slideDown',
	                    timeOut: 4000
	                };
	                if($scope.recipeForm.messageType == "Success"){
	                	toastr.success($scope.recipeForm.successOrErrorMessage);
	                }else{
	                	toastr.error($scope.recipeForm.successOrErrorMessage);
	                }
	 	    });
      	  }
	  };
});