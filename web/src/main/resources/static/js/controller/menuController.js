//定义处理器
app.controller("menuController", function ($scope, $http, menuService, uploadService) {

    //保存
    $scope.save = function () {
        var validateMsg = $("#validateMsg").val();

        alert($("#tasteSelect").val());

        if (validateMsg == "true"){
            $scope.entity.taste = $("#tasteSelect").val();

            var obj;
            if($scope.entity.menuId != null){
                //更新
                obj = menuService.update($scope.entity);
            } else {
                obj = menuService.add($scope.entity);
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
        }

    };

    //批量删除
    $scope.delete = function () {
        if($scope.selectedIds.length == 0){
            alert("请选择要删除的记录");
            return ;
        }
        //confirm如果点击 确认 则返回true,否则false
        if(confirm("确认要删除选中的记录吗？")){
            menuService.delete($scope.selectedIds).success(function (response) {
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
    $scope.search = function () {
        menuService.search($scope.searchParam).success(function (response) {
            $scope.carouselDesignsList = response.carouselDesignsList;
            $scope.stapleFoodList = response.stapleFoodList;
            $scope.snackList = response.snackList;
            $scope.soupList = response.soupList;
            $scope.sweetMeatsList = response.sweetMeatsList;
            $scope.dressingList = response.dressingList;
        });
    };

    //根据id查询
    $scope.findOne = function (menuId) {
        menuService.findOne(menuId).success(function (response) {
            $scope.entity = response;
            $("#tasteSelect").val($scope.entity.taste);
            $("#menuId").val(menuId);
        });
    };

    //根据id删除
    $scope.deleteOne = function (menuId) {
        //confirm如果点击 确认 则返回true,否则false
        if(confirm("确认要删除选中的记录吗？")){
            menuService.deleteOne(menuId).success(function (response) {
                if(response.status){
                    //刷新列表
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            });
        }

    };

    //新建操作时，如果表单已经提交了就清除之前的数据，如果表单没有提交则保留原有数据
    $scope.clean = function () {
        var validateMsg = $("#validateMsg").val();
        if(validateMsg == "true"){
            $scope.entity = {};

            //选择所有以'Td'结尾的id
            $("[id$='Td']").html("");
            $("#tasteSelect").val("");
            $("#menuId").val("");
        }

    };

    //关闭编辑窗口，清空数据
    $scope.fresh = function(){
        $("#validateMsg").val(true);
        $("#tasteSelect").val("");
        $("#menuId").val("");
    };

    //上传商品图片
    $scope.uploadFile = function () {
        uploadService.uploadFile().success(function (response) {
            if(response.status){
                $scope.entity.pictureUrl = response.message;
            } else {
                alert(response.message);
            }
        }).error(function () {
            alert("上传图片失败");
        });
    };

});