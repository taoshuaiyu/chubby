/**
 * Created by BaoBao on 2017/9/23.
 */
    //测试数据
layui.use(['table', 'element','laypage','layer'], function(){
    var table = layui.table,element = layui.element,laypage = layui.laypage
        ,layer = layui.layer;
    //执行渲染
    var tableIns = table.render({
        elem: '#article_table', //指定原始表格元素选择器（推荐id选择器）
        url:'/article/list',
        even:true,
        limit:10,
        cols: [[
            {field:'username', title: '文章标题', width:250},
            {field:'password', title: '发布时间', width:250},
            {field:'signature', title: '所属分类', width:250},
            {field:'portraitId', title: '发布状态', width:250},
            {fixed: 'right',title: '操作', width:580, align:'center', toolbar: '#barDemo'}
        ]], //设置表头
    });

    //调用分页
    laypage.render({
        elem: 'article_page'
        ,count: 20
        ,theme: '#1E9FFF'
        ,curr:1
        ,jump: function(obj){
            //模拟渲染
            tableIns.reload({
                    where: { //设定异步数据接口的额外参数，任意设
                        page: obj.curr,
                    }
                });
        }
    });
});