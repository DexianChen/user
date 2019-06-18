//定义service
app.service("userService", function ($http) {
    // //查询所有品牌列表；this表示brandService
    // this.findAll = function () {
    //     return $http.get("../brand/findAll.do");
    // };
    //
    // //分页查询
    // this.findPage = function (page, rows) {
    //     return $http.get("../brand/findPage.do?page=" + page + "&rows=" + rows);
    //
    // };

    //保存
    this.add = function (entity) {
        return $http.post("http://localhost:8762/user/insert", entity);
    };

    //更新
    this.update = function (entity) {
        return $http.post("http://localhost:8762/user/update", entity);
    };

    //根据id查询
    this.findOne = function (userId) {
        return $http.get("http://localhost:8762/user/findOne?userId=" + userId);
    };

    //批量删除
    this.delete = function (selectedIds) {
        return $http.get("http://localhost:8762/user/delete?userIds=" + selectedIds);
    };

    //根据id删除
    this.deleteOne = function(userId){
        return $http.get("http://localhost:8762/user/deleteOne?userId=" + userId);
    };

    //分页条件查询
    this.search = function () {
        return $http.get("http://localhost:8762/user/list");
    };
});