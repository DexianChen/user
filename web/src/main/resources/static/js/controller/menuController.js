//定义处理器
app.controller("menuController", function ($scope, $http, $controller, menuService, uploadService, address) {

    //继承controller，可以使用baseController中的所有方法
    $controller("baseController", {$scope:$scope});

    //保存
    $scope.save = function () {
        var validateMsg = $("#validateMsg").val();

        if (validateMsg == "true"){
            $scope.entity.taste = $("#sexSelect").val();

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
    $scope.search = function (currentPage, itemsPerPage) {
        menuService.search(currentPage, itemsPerPage, $scope.searchParam).success(function (response) {
            //设置列表
            $scope.list = response.rows;
            //更新分页导航条
            $scope.paginationConf.totalItems = response.total;//总记录数
        });
    };

    //根据id查询
    $scope.findOne = function (menuId) {
        menuService.findOne(menuId).success(function (response) {
            $scope.entity = response;
            //将性别以及地址进行回显
            $("#sexSelect").val($scope.entity.sex);

            $("#selProvince").val($scope.entity.addressProvince);

            var Citys = address.getCitys();
            $('#selCity').children().not(':eq(0)').remove();
            var iNum1 = $('#selProvince').children('option:selected').index();
            var city = Citys[iNum1 - 1];
            for (var j = 0; j < city.length; j++) {
                $('#selCity').append('<option>' + city[j] + '</option>');
            }
            $("#selCity").val($scope.entity.addressCity);

            var Areas = address.getAreas();
            $('#selArea').children().not(':eq(0)').remove();
            var iNum2 = $("#selCity").children('option:selected').index();
            var area = Areas[iNum1 - 1][iNum2 - 1];
            for (var k = 0; k < area.length; k++) {
                    $('#selArea').append('<option>' + area[k] + '</option>');
            }
            $("#selArea").val($scope.entity.addressArea);

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
            $("#sexSelect").val("");
            $("#selProvince").val("");
            $("#selCity").val("");
            $("#selArea").val("");
            $("#menuId").val("");
        }

    };

    //关闭编辑窗口，清空数据
    $scope.fresh = function(){
        $("#validateMsg").val(true);
        $("#sexSelect").val("");
        $("#selProvince").val("");
        $("#selCity").val("");
        $("#selArea").val("");
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