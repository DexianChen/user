app.controller("itemController", function ($scope, menuService) {
    // 根据id查询
    $scope.loadMenu = function () {
        var menuId = window.location.search.substring(1).split("=")[1];
        menuService.findOne(menuId).success(function (response) {
            $scope.menu = response;
        });
    };
});