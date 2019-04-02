//index首页配置文件
layui.config({//全局配置
	base: '/site/js/layuibase/js/'
}).use(['element', 'layer', 'navbar', 'tab','form'], function() {//加载
	var element = layui.element(),
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form,
		navbar = layui.navbar(),
		tab = layui.tab({
			elem: '.admin-nav-card' //设置选项卡容器
		});
	//设置navbar导航栏
	navbar.set({
		spreadOne: true,
		elem: '#admin-navbar-side',
		cached: true,
		data: navss

	});
});
