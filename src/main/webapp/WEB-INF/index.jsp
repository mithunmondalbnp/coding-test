<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Manager</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Toastr style -->
    <link href="resources/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <!-- Gritter -->
    <link href="resources/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script type="text/javascript" src="resources/app.js"></script>
</head>
<body ng-app="recipemanager" ng-controller="recipemanagerController" style="background-color: #f5f5f5;">
    <div id="wrapper">
        <div id="viewRecipe" class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">
                    <div class="row">
                    <div class="col-lg-12">
                    		<center><h1>Recipe Manager</h1></center>
		                    <div class="ibox float-e-margins">
		                        <div class="ibox-title">
		                            <h5>Add/View Recipe</h5>
		                        </div>
		                        <div class="ibox-content">
		                        	<div class="col-sm-12">
			                        	<select class="form-control m-b" id="recipes">
	                                        <option value="">Select Recipe....</option>
	                                        <c:forEach var="recipe" items="${recipes}">
										      <option value="${recipe.recipeId}">${recipe.recipeName}</option>
										    </c:forEach>
	                                    </select>
                                    </div>
		                            <form class="form-horizontal">
		                            	<input type="hidden" ng-model="recipeForm.recipeId">
		                                <div class="form-group"><label class="col-lg-2 control-label">Recipe Name</label>
		                                    <div class="col-lg-10"><input type="text" placeholder="Recipe Name" class="form-control" ng-model= "recipeForm.recipeName"></div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Ingredient 1</label>
		                                    <div class="col-lg-10"><input type="text" placeholder="Ingredient 1" class="form-control" ng-model= "recipeForm.ingredient1"></div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Ingredient 2</label>
		                                    <div class="col-lg-10"><input type="text" placeholder="Ingredient 2" class="form-control" ng-model= "recipeForm.ingredient2"></div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Ingredient 3</label>
		                                    <div class="col-lg-10"><input type="text" placeholder="Ingredient 3" class="form-control" ng-model= "recipeForm.ingredient3"></div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Ingredient 4</label>
		                                    <div class="col-lg-10"><input type="text" placeholder="Ingredient 4" class="form-control" ng-model= "recipeForm.ingredient4"></div>
		                                </div>
		                                <div class="form-group">
		                                    <div class="col-lg-offset-2 col-lg-10">
		                                        <button class="btn btn-sm btn-white" type="button" ng-click="saveRecipe()">Add/Update Recipe</button>
		                                        <button class="btn btn-sm btn-white" type="button" ng-click="deleteRecipe()">Delete Recipe</button>
		                                        <button class="btn btn-sm btn-white" type="button" id="getRecipe" ng-click="getRecipe()">Add/Update Recipe</button>
		                                    </div>
		                                </div>
		                            </form>
		                        </div>
		                    </div>
		                </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="resources/js/jquery-2.1.1.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Flot -->
    <script src="resources/js/plugins/flot/jquery.flot.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="resources/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="resourcesjs/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI -->
    <script src="resourcesjs/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- Toastr -->
    <script src="resources/js/plugins/toastr/toastr.min.js"></script>

    <script>
        $(document).ready(function() {
        	$("#getRecipe").hide();
        	$( "#recipes" ).change(function() {
        		$("#getRecipe").click();
        	});
        });
    </script>
</body>
</html>
