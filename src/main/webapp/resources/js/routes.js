'use strict';

angular.module('gymApp').config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'resources/partials/home.html',
            controller: ''
        })
        .when('/employees', {
            templateUrl: 'resources/partials/employees.html',
            controller: ''
        })
        .when('/members', {
            templateUrl: 'resources/partials/members.html',
            controller: ''
        })
        .when('/about', {
            templateUrl: 'resources/partials/about.html',
            controller: ''
        })
        .when('/memberships', {
            templateUrl: 'resources/partials/memberships.html',
            controller: ''
        })
        .otherwise({redirectTo: '/home'});
}]);