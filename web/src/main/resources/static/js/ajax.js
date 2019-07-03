$(function () {
    
    sendChapterInfo = function (chapterList) {
        // 采用AJAX将章的列表信息发送到后端
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/chapter',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
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

    sendNodeInfo = function (nodeList) {
        // 采用AJAX将节的列表信息发送到后端
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/node',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
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

    sendItemInfo = function (itemList,itemDescriptionList) {
        // 采用AJAX将条文的列表信息发送到后端
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'http://localhost:8762/ajax/book/item',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据
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
});