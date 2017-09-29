<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"/>
    </link>
    <style>
        *{
            box-sizing: border-box;
        }
        .mt{
            margin-bottom: 6px;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
<#include "../common/head.ftl"/>
<#include "../common/nav.ftl"/>
    <div class="layui-body" style="background: #f5f5f5;">
        <!-- 内容主体区域 -->
        <div style="color:#7243ff;font-size:20px;padding: 20px;margin-left: 10px;">分类/标签管理</div>

        <div style="padding: 10px;">
            <div style="float: left;width:50%;">
                <div style="background: #6e8cd7;height: 60%;color: white;"><p
                        style="text-align: left;margin-left:20px;line-height: 43px">分类标签</p></div>
                <div style="background: #fff;">
                    <div style="padding: 3%">
                        <button class="layui-btn layui-btn-primary">Mybatis(3)</button>
                        <button class="layui-btn layui-btn-normal">Java(2)</button>
                        <button class="layui-btn layui-btn-warm">RocketMQ(1)</button>
                        <button class="layui-btn layui-btn-danger">Redis(3)</button>
                    </div>
                </div>
            </div>
            <div style="padding-left: 20px;float: left;width:50%;">
                <div style="background: #6e8cd7;height: 60%;color: white;"><p
                        style="text-align: left;margin-left:20px;line-height: 43px">标签列表</p></div>
                <div style="background: #fff;">
                    <div style="padding: 3%">
                        <button class="layui-btn layui-btn-primary mt">Mybatis(3)</button>
                        <button class="layui-btn layui-btn-normal mt">Java(2)</button>
                        <button class="layui-btn layui-btn-warm mt">RocketMQ(1)</button>
                        <button class="layui-btn layui-btn-danger mt">Redis(3)</button>
                    </div>
                </div>
            </div>
        </div>
        <div style="width: 100%;float: left;margin-top:10px;padding:0 10px;">
            <div style="background: #fff;
        height:80px;width: 100%;line-height: 80px;">
                <div class="layui-form-item" style="width: 20%;margin-left: 20px;
                float:left;">
                    <input type="text" style="display: inline-block" name="categoryName" placeholder="请输入分类名称" autocomplete="off"
                           class="layui-input">
                </div>
                <div style="display: inline-block;float: left;">
                    <button class="layui-btn layui-btn" style="margin-left:8px;background: #33b86c;display: inline-block">保存分类</button>
                </div>
            </div>
        </div>

    </div>
<#include "../common/footer.ftl"/>
</div>

<script src="../../static/layui/layui.js"></script>
<script>
    layui.use(['element'], function () {
        var element = layui.element;
    });
</script>
</body>
</html>