$(function () {
    // 章、节、条文对象列表及其对象
    var chapterList = [];
    var nodeList = [];
    var itemList = [];
    var otherInfoList = [];
    var chapter = {"chapterId":"", "chapterTitle":""};
    var node = {"chapterId":"", "nodeId":"", "nodeContent":""};
    var item = {"chapterId":"", "nodeId":"", "itemId":"", "itemContent":"", "itemDescription":""};
    var otherInfo = {"title":"", "content":""};

    /**
     * 构建章列表和节列表信息
     * $("#book_page div:not('[id]')").find("p")  id为book_page的div后代不含id属性的div标签下所有p标签元素
     */
    var array = $("#3199320").nextUntil("#3199358").children("div").find("p").toArray();
    $.each(array, function (index, value) {
        var html = $(value).html();

        var firstSpace_index = html.indexOf(" ");

        //以数字开头的正则表达式
        var textReg = /^\d/;
        if (textReg.test(html)) {
            // 判断是否含有<br>,有些章带着节，中间有<br>
            if (html.indexOf("<br>") == -1) {
                // ．非句号，从页面拷贝过来，不含该符号的即为章
                if (html.indexOf("．") == -1) {
                    chapter = {"chapterId":html.substring(0,firstSpace_index), "chapterTitle":html.substring(firstSpace_index).trim()};
                    chapterList.push(chapter);
                }else {
                    //含该符号则为节或条纹
                    var htmlSplit = html.substring(0,firstSpace_index).split("．");
                    var lenght = htmlSplit.length;
                    if (lenght == 2){
                        // 没带章的节
                        node = {"chapterId":html.substring(0,html.indexOf("．")), "nodeId":html.substring(0,html.indexOf("．")+2), "nodeContent":html.substring(html.indexOf("．")+2).trim()};
                        nodeList.push(node);
                    }
                }
            }else {
                //带着节的章，则截取
                chapter = {"chapterId":html.substring(0,firstSpace_index), "chapterTitle":html.substring(firstSpace_index, html.indexOf("<br>")).trim()};
                chapterList.push(chapter);

                //带着章的节，则截取
                var nodeStr = html.substring(html.indexOf("<br>")+4);
                nodeStr = nodeStr.substring(nodeStr.indexOf("<br>")+4).trim();
                node = {"chapterId":nodeStr.substring(0,nodeStr.indexOf("．")), "nodeId":nodeStr.substring(0,nodeStr.indexOf("．")+2), "nodeContent":nodeStr.substring(nodeStr.indexOf("．")+2).trim()};
                nodeList.push(node);
            }
        }
    });

    /**
     * 构建条文列表信息
     * 3199320  前言所在div
     * $("#3199320").nextAll().children("p")  id为3199320的div后所有同辈元素的所有子代p标签元素
     * 3199352 附录A所在的div
     */
    var itemArray = $("#3199320").nextUntil("#3199352").children("p").toArray();
    var itemId = "";
    var itemContent = "";
    var item_chapterId = "";
    var item_nodeId = "";
    $.each(itemArray, function (index, v1) {
        var array1 = $(v1).html().split("<br>");
        $.each(array1, function (index1, value){
            value = value.trim();

            // 含有句号表明有条文编号所在, 否则为文本信息
            if (value.trim().indexOf("．") == 1 || value.trim().indexOf("．") == 2){
                if (itemId != ""){
                    item = {"chapterId":item_chapterId, "nodeId":item_nodeId, "itemId":itemId, "itemContent":itemContent, "itemDescription":""};
                    itemList.push(item);
                    itemContent = "";
                }
                itemId = value.substring(0, value.indexOf(" "));
                item_chapterId = itemId.split("．")[0];
                item_nodeId = itemId.split("．")[1];
                itemContent += value.substring(value.indexOf(" ")).trim();
            }else if (value.indexOf("<img") != -1){
                itemContent += " " + value.substring(value.indexOf("http"), value.indexOf("\">")) + " ";
            }else {
                itemContent += value;
            }
        });
        // 最后一个元素
        if (index == itemArray.length - 1) {
            item = {"chapterId":item_chapterId, "nodeId":item_nodeId, "itemId":itemId, "itemContent":itemContent, "itemDescription":""};
            itemList.push(item);
        }
    });

    /**
     * 获取条文说明列表信息
     *  3199358 条文说明前言所在的div位置
     * @type {Array}
     */
    var itemDescriptionList = [];
    var itemDescriptionObject = {"id":"","description":""};
    var id = "";
    var description = "";
    var itemDescriptionArray = $("#3199358").nextAll().children("p").toArray();
    $.each(itemDescriptionArray, function (index, v1) {
        var array1 = $(v1).html().split("<br>");
        $.each(array1, function (index1, value) {
            value = value.trim();
            if (value.indexOf("．") == 1 || value.indexOf("．") == 2){
                if (id != ""){
                    itemDescriptionObject = {"id":id, "description":description};
                    itemDescriptionList.push(itemDescriptionObject);
                    description = "";
                }
                id = value.substring(0, value.indexOf(" "));
                description += value.substring(value.indexOf(" "));
            }else if (value.indexOf("<img") != -1){
                description += " " + value.substring(value.indexOf("http"), value.indexOf("\">")) + " ";
            }else {
                description += value;
            }
        });

        // 添加最后一个元素
        if (index == itemDescriptionArray.length - 1) {
            itemDescriptionObject = {"id":id, "description":description};
            itemDescriptionList.push(itemDescriptionObject);
        }
    });

    /**
     * 获取前言以及附录等信息
     */
    // 获取前言
    var introductionTitle = $("#book_page > div:first > div").text();
    var introductionContent = $("#book_page > div:first > p").text();
    otherInfoList.push({"title":introductionTitle, "content":introductionContent});

    /* 获取其他信息
        3199352 附录A所在的div位置
        3199358 条文说明前言所在的div位置
     */
    var otherInfoArray = $("#3199351").nextUntil("#3199359").toArray();
    $.each(otherInfoArray, function (index,value) {
        var childrenEle = $(value).children();
        var title = $(childrenEle).eq(0).text();
        var contentArray = $(childrenEle).eq(0).nextAll();
        var content = "";
        $.each(contentArray, function (index, v1) {
            var html = $(v1).html()

            if(html.indexOf("<img") != -1){
                // 含有图片的内容
                content += " " + html.substring(html.indexOf("http")).replace("\">","") + " ";
            }else {
                content += html;
            }
        });
        otherInfoList.push({"title":title, "content":content});
    });

    /**
     * 将书籍信息包装好后采取AJAX的方式发送到后台
     */
    // sendChapterInfo(chapterList);
    // sendNodeInfo(nodeList);
    sendItemInfo(itemList, itemDescriptionList);
    // sendOtherInfo(otherInfoList);

    // $.each(itemDescriptionList, function (index, value) {
    //     if (value.id.indexOf("6．5．2")!=-1) {
    //         alert(value.id + "--->" + value.description);
    //     }
    // });
});