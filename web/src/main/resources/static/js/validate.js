/**
 * 用于前端进行信息校验
 */


//菜式名称, 不为空，值唯一
checkName = function(){
    var name = $("#name").val();
    if (name == null || name == "" ) {
        $("#nameTd").html("<span style='color: red'>请输入菜式名称</span>");
        return false;
    }else {
        var menuId = $("#menuId").val();
        //userId为空即为新建，需要判断是否唯一
        if (menuId == null || menuId == "") {
            $.ajax({
                //请求方式
                type:'POST',
                //发送请求的地址
                url:'http://localhost:8762/ajax/name',
                //服务器返回的数据类型
                dataType:'json',
                //发送到服务器的数据
                data:{name: name},
                success:function(data){
                    if (data.status) {
                        $("#nameTd").html("<span style='color: green'>" + data.message +"</span>");
                        return true;
                    }else {
                        $("#nameTd").html("<span style='color: red'>" + data.message +"</span>");
                        return false;
                    }
                },
                error:function(){
                    alert("服务器开小差了，请重新输入！");
                }
            });
        }
        $("#nameTd").html("");
        return true;
    }
};

//校验是否进行插入或更改操作
checkForm = function () {
    if (!checkName()){
        alert("表单信息有误，请重新填写");
        $("#validateMsg").val(false);
    }else {
        $("#validateMsg").val(true);
    }
};
