function Hello($scope, $http) {
    
    $scope.getCountry = function(){
        $http.get('http://localhost:8080/country?id='+$scope.id).
        success(function(data) {
            $scope.country = data;
        });
    }
    
    $scope.top5 = function(){
        $http.get('http://localhost:8080/top5').
                success(function(data) {
                    $scope.countries = data;
        });
    }
    
    $scope.all = function(){
        $http.get('http://localhost:8080/all').
                success(function(data) {
                    $scope.allcountries = data;
        });
    }
}

