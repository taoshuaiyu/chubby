<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css"/>
    </link>
</head>
<body>
<div class="layui-layout layui-layout-admin">
<#include "common/head.ftl"/>
<#include "common/nav.ftl"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域index</div>
    </div>
<#include "common/footer.ftl"/>
</div>
<script src="../static/layui/layui.js"></script>
<script>
</script>
</body>
</html>