/**
 * 用于前端进行信息校验
 */

//校验账户
testAccount = function(){
    var account = $("#account").val();
    if (account == null || account == "" ) {
        alert("请输入账户名");
    }
};

//校验真实姓名
testRealName = function(){
    var realName = $("#realName").val();
    if (realName == null || realName == "" ) {
        alert("请输入真实姓名");
    }
};

//校验身份证
testIdCard = function(){
    var idCard = $("#idCard").val();
    var idcardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    if (idCard == null || idCard == "") {
        alert("请输入身份证信息");
    }else {
        if(!idcardReg.test(idCard)) {
            // 不合法
            alert("身份证不合法，请重写！");
        }
    }
};

//校验电话号码
testPhone = function(){
    var phone = $("#phone").val();
    var phoneReg = /^1(3|4|5|7|8)\d{9}$/;
    if (phone == null || phone == "") {
        alert("请输入电话号码");
    }else {
        if(!phoneReg.test(phone)) {
            // 不合法
            alert("电话号码不合法，请重写！");
        }
    }
};

//校验邮箱地址
testEmail = function(){
    var email = $("#email").val();
    var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if (email == null || email == "") {
        alert("请输入邮箱地址");
    }else {
        if(!emailReg.test(email)) {
            // 不合法
            alert("邮箱地址不合法，请重写！");
        }
    }
};
