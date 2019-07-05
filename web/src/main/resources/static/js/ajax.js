/**
 * 将书籍信息发送到后端
 */
$(function () {

    /**
     * 采用AJAX将章的列表信息发送到后端
     * @param chapterList
     */
    sendChapterInfo = function (chapterList) {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/chapter',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，转换为json格式
            data:{chapterList: JSON.stringify(chapterList)},
            success:function(data){
                if (data.status) {
                    alert(data.message);
                }else {
                    alert(data.message);
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    };

    /**
     * 采用AJAX将节的列表信息发送到后端
     * @param nodeList
     */
    sendNodeInfo = function (nodeList) {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/node',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，转换为json格式
            data:{nodeList: JSON.stringify(nodeList)},
            success:function(data){
                if (data.status) {
                    alert(data.message);
                }else {
                    alert(data.message);
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    };

    /**
     * 采用AJAX将条文的列表信息发送到后端
     * @param itemList
     * @param itemDescriptionList
     */
    sendItemInfo = function (itemList,itemDescriptionList) {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/item',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，转换为json格式
            data:{
                itemList: JSON.stringify(itemList),
                itemDescriptionList: JSON.stringify(itemDescriptionList)
                },
            success:function(data){
                if (data.status) {
                    alert(data.message);
                }else {
                    alert(data.message);
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    };

    /**
     * // 采用AJAX将其他列表信息(包括前言和附录等)发送到后端
     * @param otherList
     */
    sendOtherInfo = function (otherList) {
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/other',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，转换为json格式
            data:{otherList: JSON.stringify(otherList)},
            success:function(data){
                if (data.status) {
                    alert(data.message);
                }else {
                    alert(data.message);
                }
            },
            error:function(){
                alert("服务器开小差了，请重新输入！");
            }
        });
    };
});