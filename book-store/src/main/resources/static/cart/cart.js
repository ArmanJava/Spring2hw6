angular.module('app').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store';

    fillTable = function () {
        $http.get(contextPath + '/api/v1/cart')
            .then(function (response) {
                console.log(123);
                $scope.CartList = response.data;
            });
    };

    fillTable();
});