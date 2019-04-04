//index首页配置文件
layui.config({//全局配置
	base: 'site/js/layuibase/plugins/layui/lay/modules/'
}).use(['element', 'layer', 'navbar', 'tab','form','table'], function() {//加载
	var element = layui.element(),
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form,
		navbar = layui.navbar(),
    	table = layui.table,
        tab = layui.tab({
            elem: '.admin-tab' //设置选项卡容器
        });
    //渲染navbar
    navbar.render();
    //监听点击事件
    navbar.on('click(test)', function() {


    layer.alert("gg");
});
});

