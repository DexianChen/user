// 点击元素，窗口滚动
$(function () {
    //on(事件,[子代选择器],[数据],函数)
    $('.c_nav2').on('click',function(event){
        //event是指点击事件, event.target是指最初触发事件的DOM元素。
        var target = event.target;

        //data-to, 其中data为key,to为value, go1等为具体的值
        var id = $(target).data("to");

        //offset([condiction])获取匹配元素在当前视口的相对偏移
        $('html,body').animate({scrollTop:$('#'+id).offset().top}, 800);
    });
});