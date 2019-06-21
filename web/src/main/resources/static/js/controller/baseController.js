app.controller("baseController", function ($scope) {
    // 初始化分页参数
    $scope.paginationConf = {
        currentPage:1,// 当前页号
        totalItems:10,// 总记录数
        itemsPerPage:5,// 页大小
        perPageOptions:[5, 20, 50],// 可选择的每页大小
        onChange: function () {// 当上述的参数发生变化了后触发
            $scope.reloadList();
        }
    };

    //重新加载列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };


    //当前选择了的id集合
    $scope.selectedIds = [];

    //选择id
    $scope.updateSelection = function ($event, id) {
        if($event.target.checked){//选中
            $scope.selectedIds.push(id);
        } else {
            //反选，则需要从选中集合中删除
            var index = $scope.selectedIds.indexOf(id);

            //参数1：删除元素对应索引号，参数2：删除的个数
            $scope.selectedIds.splice(index, 1);
        }

    };

});