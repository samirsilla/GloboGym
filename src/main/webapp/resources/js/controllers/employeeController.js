gymApp.controller('EmployeeController', ['$http', '$scope', function($http, $scope){

    $scope.findAllEmployees = function() {
        $http.get('/api/employee/all').success(function (data) {
            $scope.employees = data;
        });
    };

    $scope.updateEmployee = function(employee) {
        $http.post('/api/employee/update/'+employee.employeeId, JSON.stringify(employee)).success(function () {
            $scope.findAllEmployees();
        });
    };
    $scope.createEmployee = function(employee) {
        $http.post('/api/employee/create', JSON.stringify(employee)).success(function () {
            $scope.clearAdd(employee);
            $scope.findAllEmployees();
        });
    };
    $scope.deleteEmployee = function(id) {
        $http.delete('/api/employee/delete/'+id).success(function () {
            $scope.findAllEmployees();
        });
    };

    $scope.clearAdd = function(employee){
        angular.element('#first-name').value = null;
        angular.element('#last-name').value = null;
        angular.element('#employee-number').value = null;
        angular.element('#phone-number').value = null;

        employee.lastName = null;
        employee.firstName = null;
        employee.employeeNumber = null;
        employee.phoneNumber = null;
    };

    $scope.showForm = false;
    $scope.findAllEmployees();
}]);