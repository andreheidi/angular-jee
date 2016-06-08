var app = angular.module('personController', []);

app.controller('personList', function ($scope, $http) {
    $http.get('http://localhost:8080/angular-jee/view/personController/list').then(function(response) {
        $scope.persons = response.data;
    });
});

app.controller('formPerson', function($scope, $http) {
    $scope.person = {name:'', cpf:''};

    $scope.save = function(person) {
        $http.post('http://localhost:8080/angular-jee/view/personController/save', $scope.person);

        // Inappropriate
        window.location.reload();
    }

});

app.filter('cpf', function(){
    return function(cpf){
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3) + '-' + cpf.substr(9,2);
    };
});