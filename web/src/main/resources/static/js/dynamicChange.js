// jQuery实现左右div自适应相同高度
$(function () {
    $(window).scroll(function () {
       var windowTop = $(this).scrollTop();
       if(windowTop < 85){
           $("#left").css({top:"85px"});
       }else {
           $("#left").css({top: windowTop + "px"});
       }
   });
});