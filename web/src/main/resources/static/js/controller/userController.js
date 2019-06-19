//定义处理器
app.controller("userController", function ($scope, $http, $controller, userService) {

    //继承controller，可以使用baseController中的所有方法
    $controller("baseController", {$scope:$scope});

    // //查询所有品牌列表
    // $scope.findAll = function () {
    //     userService.findAll().success(function (response) {
    //         $scope.list = response;
    //     }).error(function () {
    //         alert("查询列表失败");
    //     });
    //
    // };
    //
    // //分页查询
    // $scope.findPage = function (page, rows) {
    //     userService.findPage(page, rows).success(function (response) {//response是分页对象PageResult
    //         //设置列表
    //         $scope.list = response.rows;
    //         //更新分页导航条
    //         $scope.paginationConf.totalItems = response.total;//总记录数
    //     });
    //
    // };

    //保存
    $scope.save = function () {
        var obj;
        if($scope.entity.userId != null){
            //更新
            obj = userService.update($scope.entity);
        } else {
            obj = userService.add($scope.entity);
        }
        //$scope.entity 弹出层里面双向绑定的那些表单项
        obj.success(function (response) {
            if(response.status){
                //刷新列表
                $scope.reloadList();
            } else {
                alert(response.message);
            }
        });

    };

    //批量删除
    $scope.delete = function () {
        if($scope.selectedIds.length == 0){
            alert("请选择要删除的记录");
            return ;
        }
        //confirm如果点击 确认 则返回true,否则false
        if(confirm("确认要删除选中的记录吗？")){
            userService.delete($scope.selectedIds).success(function (response) {
                if(response.status){
                    //刷新列表
                    $scope.reloadList();
                    $scope.selectedIds = [];
                } else {
                    alert(response.message);
                }
            });
        }

    };

    //分页条件查询
    $scope.searchParam = "";
    $scope.search = function (currentPage, itemsPerPage) {
        userService.search(currentPage, itemsPerPage, $scope.searchParam).success(function (response) {
            //设置列表
            $scope.list = response;
        });
    };

    //根据id查询
    $scope.findOne = function (userId) {
        userService.findOne(userId).success(function (response) {
            $scope.entity = response;
        });
    };

    //根据id删除
    $scope.deleteOne = function (userId) {
        //confirm如果点击 确认 则返回true,否则false
        if(confirm("确认要删除选中的记录吗？")){
            userService.deleteOne(userId).success(function (response) {
                if(response.status){
                    //刷新列表
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            });
        }

    };

    //新建操作时，清除之前的数据
    $scope.clean = function () {
        $scope.entity = {};
    }

});