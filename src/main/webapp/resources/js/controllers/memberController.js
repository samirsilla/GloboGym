gymApp.controller('MemberController', ['$http', '$scope', function($http, $scope){

    $scope.findAllMembers = function() {
        $http.get('/api/member/all').success(function (data) {
            $scope.members = data;
        });
    };

    $scope.updateMember = function(member) {
        $http.post('/api/member/update/'+member.memberId, JSON.stringify(member)).success(function () {
            $scope.findAllMembers();
        });
    };
    $scope.createMember = function(member) {
        $http.post('/api/member/create', JSON.stringify(member)).success(function () {
            $scope.clearAdd(member);
            $scope.findAllMembers();
        });
    };
    $scope.deleteMember = function(id) {
        $http.delete('/api/member/delete/'+id).success(function () {
            $scope.findAllMembers();
        });
    };

    $scope.clearAdd = function(member){
        angular.element('#first-name').value = null;
        angular.element('#last-name').value = null;
        angular.element('#phone-number').value = null;

        member.lastName = null;
        member.firstName = null;
        member.phoneNumber = null;
    };

    $scope.showForm = false;
    $scope.findAllMembers();
}]);