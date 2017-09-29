<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    <link href="../../static/editormd/markdowneditormd.css" rel="stylesheet"/>
    </link>
</head>
<body>
<div class="layui-layout layui-layout-admin">
<#include "../common/head.ftl"/>
<#include "../common/nav.ftl"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="color:#7243ff;font-size:20px;padding: 15px;margin-left: 10px;">陶小胖 - 文章管理</div>
        <div id="content" name="content"></div>
    </div>
<#include "../common/footer.ftl"/>
</div>

<script  src="../../static/js/jquery.min.js"></script>
<script src="../../static/layui/layui.js"></script>
<script src="../../static/js/article/article.js"></script>
<script  src="../../static/editormd/editormd.min.js"></script>


<script>
    var testEditor;
    $(function(){
        aa();
        // 初始化内容
        testEditor = editormd("content", {
            width   : "90%",
            height  : 320,
            syncScrolling : "single",
            path    : "../../static/editormd/lib/",
            saveHTMLToTextarea : true
        });
    });
    function aa() {
        alert("haha")
    }
</script>
</body>
</html>