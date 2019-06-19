/**
 * 用于前端进行信息校验
 */

//校验账户, 不为空，值唯一
checkAccount = function(){
    var account = $("#account").val();
    if (account == null || account == "" ) {
        alert("请输入账户名");
    }else {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/account',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
            data:{account: account},
            success:function(data){
                if (data.status) {
                    $("#accountTd").html("<span style='color: green'>" + data.message +"</span>");
                }else {
                    $("#accountTd").html("<span style='color: red'>" + data.message +"</span>");
                }
            },
            error:function(){
               alert("服务器开小差了，请重新输入！");
            }
        });
    }
};

//校验密码,不为空
checkPwd = function(){

};

//校验真实姓名，不为空
checkRealName = function(){
    var realName = $("#realName").val();
    if (realName == null || realName == "" ) {
        alert("请输入真实姓名");
    }
};

//校验身份证，不为空，值唯一，符合身份证正则表达式
checkIdCard = function(){
    var idCard = $("#idCard").val();
    if (idCard == null || idCard == "") {
        alert("请输入身份证信息");
    }else {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/idCard',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
            data:{idCard: idCard},
            success:function(data){
                if (data.status) {
                    $("#idCardTd").html("<span style='color: green'>" + data.message +"</span>");

                    var idcardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
                    if(!idcardReg.test(idCard)) {
                        // 不合法
                        alert("身份证不合法，请重写！");
                    }
                }else {
                    $("#idCardTd").html("<span style='color: red'>" + data.message +"</span>");
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    }
};

//校验电话号码，不为空，值唯一，符合电话号码的正则表达式
checkPhone = function(){
    var phone = $("#phone").val();
    if (phone == null || phone == "") {
        alert("请输入电话号码");
    }else {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/phone',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
            data:{phone: phone},
            success:function(data){
                if (data.status) {
                    $("#phoneTd").html("<span style='color: green'>" + data.message +"</span>");

                    var phoneReg = /^1(3|4|5|7|8)\d{9}$/;
                    if(!phoneReg.test(phone)) {
                        // 不合法
                        alert("电话号码不合法，请重写！");
                    }
                }else {
                    $("#phoneTd").html("<span style='color: red'>" + data.message +"</span>");
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    }
};

//校验邮箱地址，不为空，值唯一，符合邮箱的正则表达式
checkEmail = function(){
    var email = $("#email").val();
    if (email == null || email == "") {
        alert("请输入邮箱地址");
    }else {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/email',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
            data:{email: email},
            success:function(data){
                if (data.status) {
                    $("#emailTd").html("<span style='color: green'>" + data.message +"</span>");

                    var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                    if(!emailReg.test(email)) {
                        // 不合法
                        alert("邮箱地址不合法，请重写！");
                    }
                }else {
                    $("#emailTd").html("<span style='color: red'>" + data.message +"</span>");
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    }
};
