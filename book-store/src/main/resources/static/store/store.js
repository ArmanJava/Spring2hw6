angular.module('app').controller('booksController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store';

    fillTable = function () {
        $http.get(contextPath + '/api/v1/books')
            .then(function (response) {
                $scope.BooksList = response.data;
            });
    };

    $scope.submitCreateNewBook = function () {
        $http.post(contextPath + '/api/v1/books', $scope.newBook)
            .then(function (response) {
                $scope.BooksList.push(response.data);
            });
    };

    $scope.applyFilter = function () {
        $http({
            url: contextPath + '/api/v1/books',
            method: "GET",
            params: {book_title: $scope.bookFilter.title}
        }).then(function (response) {
            $scope.BooksList = response.data;
        });
    }

    $scope.addToCartFunction = function(book) {
        console.log(book);
        myUrl = contextPath + '/api/v1/cart/add/' + book.id;
        console.log(myUrl);
        $http({
            url: myUrl,
            method: "GET"
        }).then(function (response) {
            console.log('added');
        });
    }

    fillTable();
});