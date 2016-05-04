'use strict';

var gymAppDirectives = angular.module('gymAppDirectives', []);
var gymAppServices = angular.module('gymAppServices', []);
var gymAppFilters = angular.module('gymAppFilters', []);
var gymAppControllers = angular.module('gymAppControllers', []);

var gymApp = angular.module('gymApp', [
    'ngRoute',
    'gymAppDirectives',
    'gymAppFilters',
    'gymAppServices',
    'gymAppControllers'
]);