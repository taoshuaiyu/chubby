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
        <div style="color:#7243ff;font-size:20px;padding: 20px;margin-left: 10px;">分类/标签管理</div>

        <div style="padding: 10px;margin-left: 10px;">
            <div style="float: left;width:49%;">
                <div style="background: #6e8cd7;height: 60%;color: white;"><p
                        style="text-align: left;margin-left:20px;line-height: 43px">分类标签</p></div>
                <div style="background: #FFEEE8;height: 100px">
                    <div style="padding: 3%">
                        <button class="layui-btn layui-btn-primary">Mybatis(3)</button>
                        <button class="layui-btn layui-btn-normal">Java(2)</button>
                        <button class="layui-btn layui-btn-warm">RocketMQ(1)</button>
                        <button class="layui-btn layui-btn-danger">Redis(3)</button>
                    </div>
                </div>
            </div>
            <div style="margin-left: 20px;float: left;width:49%;">
                <div style="background: #6e8cd7;height: 60%;color: white;"><p
                        style="text-align: left;margin-left:20px;line-height: 43px">标签列表</p></div>
                <div style="background: #FFEEE8;height: 100px">
                    <div style="padding: 3%">
                        <button class="layui-btn layui-btn-primary">Mybatis(3)</button>
                        <button class="layui-btn layui-btn-normal">Java(2)</button>
                        <button class="layui-btn layui-btn-warm">RocketMQ(1)</button>
                        <button class="layui-btn layui-btn-danger">Redis(3)</button>
                    </div>
                </div>
            </div>
        </div>
        <#--<div style="margin-top:10%;margin-left: 1%;margin-right: 1%;background: #FFEEE8;height: 80px">-->
            <#--<div class="layui-form-item" style="padding-top: 22px;width: 20%;margin-left: 20px;float: left">-->
                <#--<input type="text" name="categoryName" placeholder="请输入分类名称" autocomplete="off" class="layui-input">-->
            <#--</div>-->
            <#--<div style="float: left;padding-top: 22px">-->
                <#--<button class="layui-btn layui-btn" style="margin-left:8px;background: #33b86c">保存分类</button>-->
            <#--</div>-->
        <#--</div>-->
        <div class="layui-form">
            <table class="layui-table">
                <colgroup>
                    <col width=5%>
                    <col width=15%>
                    <col width=35%>
                    <col width=45%>
                </colgroup>
                <thead>
                <tr>
                    <th>人物</th>
                    <th>民族</th>
                    <th>出场时间</th>
                    <th>格言</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>贤心</td>
                    <td>汉族</td>
                    <td>1989-10-14</td>
                    <td>人生似修行</td>
                </tr>
                <tr>
                    <td>张爱玲</td>
                    <td>汉族</td>
                    <td>1920-09-30</td>
                    <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                </tr>
                <tr>
                    <td>Helen Keller</td>
                    <td>拉丁美裔</td>
                    <td>1880-06-27</td>
                    <td> Life is either a daring adventure or nothing.</td>
                </tr>
                <tr>
                    <td>岳飞</td>
                    <td>汉族</td>
                    <td>1103-北宋崇宁二年</td>
                    <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
                </tr>
                <tr>
                    <td>孟子</td>
                    <td>华夏族（汉族）</td>
                    <td>公元前-372年</td>
                    <td>猿强，则国强。国强，则猿更强！ </td>
                </tr>
                </tbody>
            </table>
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