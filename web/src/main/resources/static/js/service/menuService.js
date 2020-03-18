//定义service
app.service("menuService", function ($http) {

    //保存
    this.add = function (entity) {
        return $http.post("http://localhost:8762/menu/insert", entity);
    };

    //更新
    this.update = function (entity) {
        return $http.post("http://localhost:8762/menu/update", entity);
    };

    //根据id查询
    this.findOne = function (menuId) {
        return $http.get("http://localhost:8762/menu/findOne?menuId=" + menuId);
    };

    //批量删除
    this.delete = function (selectedIds) {
        return $http.get("http://localhost:8762/menu/delete?menuIds=" + selectedIds);
    };

    //根据id删除
    this.deleteOne = function(menuId){
        return $http.get("http://localhost:8762/menu/deleteOne?menuId=" + menuId);
    };

    //分页条件查询
    this.search = function (searchParam) {
        return $http.get("http://localhost:8762/menu/list?searchParam=" + searchParam);
    };
});