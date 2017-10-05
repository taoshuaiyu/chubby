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
        <div style="padding: 30px">
            <input type="text" style="width:45%;height: 37px; margin-left:20px;float:left;" name="categoryName"
                   placeholder="请输入文章标题（必须）"
                   class="layui-input">
            <input type="text" style="width:45%;height: 37px; margin-left: 50px;float:left;" name="categoryName"
                   placeholder="自定义访问路径,如：my-first-article 默认为文章id"
                   class="layui-input">
        </div>
        <div style="padding: 30px">
            <input type="text" style="width:45%;height: 37px; margin-left:20px;float:left;" name="categoryName"
                   placeholder="请输入文章标签"
                   class="layui-input">
            <form class="layui-form" style="width:45%;height: 37px; margin-left: 50px;float:left;">
                <div class="layui-form-item">
                    <label class="layui-form-label">请选择分类</label>
                    <div class="layui-input-block">
                        <select name="interest" lay-filter="aihao">
                            <option value="" selected="">请选择</option>
                            <option value="0">Java</option>
                            <option value="1">Mybatis</option>
                        </select>
                    </div>
                </div>
            </form>
        </div>
        <div style="width:90%;padding: 30px;margin-left:20px;float:left;">
            <div id="content" name="content"></div>
        </div>
        <div style="float:right;margin-right: 12%">
            <button class="layui-btn layui-btn-primary">返回列表</button>
            <button class="layui-btn" style="background-color: #6e8cd7">保存文章</button>
            <button class="layui-btn" style="background-color: #ffd740;color: #000">存为手稿</button>
        </div>
    <#include "../common/footer.ftl"/>
    </div>

    <script src="../../static/js/jquery.min.js"></script>
    <script src="../../static/layui/layui.js"></script>
    <script src="../../static/js/article/article.js"></script>
    <script src="../../static/editormd/editormd.min.js"></script>


    <script>
        var testEditor;
        $(function () {
            // 初始化内容
            testEditor = editormd("content", {
                width: "90%",
                height: 320,
                syncScrolling: "single",
                path: "../../static/editormd/lib/",
                saveHTMLToTextarea: true,
                onfullscreen: function () {
                    $("#layui-nav").hide();
                    $("#layui-header").hide();
                },
                onfullscreenExit: function () {
                    $("#layui-nav").show();
                    $("#layui-header").show();
                }
            });
            //Demo
            layui.use('form', function () {
                var form = layui.form;
            });
        });
    </script>
</body>
</html>