/**
 * 用于前端进行信息校验
 */

//是否能够提交
var accountCommit = false;
var pwdCommit = false;
var realNameCommit = false;
var idCardCommit = false;
var phoneCommit = false;
var emailCommit = false;

//校验账户, 不为空，值唯一
checkAccount = function(){
    var account = $("#account").val();
    if (account == null || account == "" ) {
        $("#accountTd").html("<span style='color: red'>请输入账户名</span>");
        accountCommit = false;
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

                    accountCommit = true;
                }else {
                    $("#accountTd").html("<span style='color: red'>" + data.message +"</span>");

                    accountCommit = false;
                }
            },
            error:function(){
               alert("服务器开小差了，请重新输入！");
            }
        });
    }
};

//校验密码,不为空，至少6位
checkPwd = function(){
    var pwd = $("#pwd").val();
    if (pwd == null || pwd == "" ) {
        $("#pwdTd").html("<span style='color: red'>请输入密码</span>");
        pwdCommit = false;
    }else if (pwd.length < 6) {
        $("#pwdTd").html("<span style='color: red'>你的密码过于简单，请重新设置！</span>");
        pwdCommit = false;
    }else {
        $("#pwdTd").html("");
        pwdCommit = true;
    }
};

//校验真实姓名，不为空
checkRealName = function(){
    var realName = $("#realName").val();
    if (realName == null || realName == "" ) {
        $("#realNameTd").html("<span style='color: red'>请输入真实姓名</span>");
        realNameCommit = false;
    }else {
        $("#realNameTd").html("");
        realNameCommit = true;
    }
};

//校验身份证，不为空，值唯一，符合身份证正则表达式
checkIdCard = function(){
    var idCard = $("#idCard").val();
    if (idCard == null || idCard == "") {
        $("#idCardTd").html("<span style='color: red'>请输入身份证信息</span>");
        idCardCommit = false;
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
                        $("#idCardTd").html("<span style='color: red'>身份证不合法，请重写！</span>");
                        idCardCommit = false;
                    }

                    idCardCommit = true;
                }else {
                    $("#idCardTd").html("<span style='color: red'>" + data.message +"</span>");
                    idCardCommit = false;
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
        $("#phoneTd").html("<span style='color: red'>请输入电话号码</span>");
        phoneCommit = false;
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
                        $("#phoneTd").html("<span style='color: red'>电话号码不合法，请重写！</span>");
                        phoneCommit = false;
                    }

                    phoneCommit = true;
                }else {
                    $("#phoneTd").html("<span style='color: red'>" + data.message +"</span>");
                    phoneCommit = false;
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
        $("#emailTd").html("<span style='color: red'>请输入邮箱地址</span>");
        emailCommit = false;
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
                        $("#emailTd").html("<span style='color: red'>邮箱地址不合法，请重写！</span>");
                        emailCommit = false;
                    }

                    emailCommit = true;
                }else {
                    $("#emailTd").html("<span style='color: red'>" + data.message +"</span>");
                    emailCommit = false;
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    }
};

//校验是否进行插入或更改操作
checkForm = function () {
    if (!accountCommit || !pwdCommit || !realNameCommit || !idCardCommit || !phoneCommit || !emailCommit){
        alert("表单信息有误，请重新填写");
        $("#validateMsg").val(false);
    }else {
        $("#validateMsg").val(true);
    }
};
