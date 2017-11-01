<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    </link>
</head>
<body>
<div class="layui-layout layui-layout-admin">
<#include "../common/head.ftl"/>
<#include "../common/nav.ftl"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="color:#7243ff;font-size:20px;padding: 15px;margin-left: 10px;">陶小胖 - 文章管理</div>
        <div style="margin-left: 30px;margin-right: 30px;">
            <table id="article_table" lay-filter="article_bar"></table>
        </div>
        <div id="article_page" style="float: right;margin-right: 30px"></div>
    </div>
<#include "../common/footer.ftl"/>
</div>
<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-small layui-btn-normal" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn layui-btn-small layui-btn-danger" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</button>
    <button class="layui-btn layui-btn-small layui-btn-warm" lay-event="detail"><i class="layui-icon">&#xe756;</i>查看</button>
</script>

<script src="../../static/layui/layui.js"></script>
<script src="../../static/js/article/article.js"></script>
</body>
</html>