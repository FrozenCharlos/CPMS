jQuery.fn.limit=function(){  
    var self = $("[limit]");  
    self.each(function(){  
        var objString = $(this).text();  
        var objLength = $(this).text().length;  
        var num = $(this).attr("limit");  
        if(objLength > num){  
            $(this).attr("title",objString);  
            objString = $(this).text(objString.substring(0,num) + "...");  
        }  
    }); 
};
$(function(){
	$(window).resize(function(){
		getHeight();
	});
	
	// 二级页面内容高度
	var container = $(".container");
	var headerH = $(".laHeader").outerHeight();
	var menuH = $(".laMenuBox").outerHeight();
	var bannerH = $(".laBannerBox").outerHeight();
	var footerH = $(".laFooter").outerHeight();
	function getHeight(){
		container.css("min-height",$("body").height() - headerH - menuH - bannerH - footerH);
	}
	getHeight();
	// 字数限制
	$("[limit]").length > 0 && $("[limit]").limit();

	// 首页轮播
	if($(".navList").length > 0){
		var navBox = $(".navBox");
		var navList = $.scrollImg(".navList", {
			width: navBox.width(),
			size: 2
		});
		$(".toPre").click(function(){
			$(".toNext").removeClass("cur");
			$(".toPre").addClass("cur");
			navList.prev();
		});
		$(".toNext").click(function(){
			$(".toPre").removeClass("cur");
			$(".toNext").addClass("cur");
			navList.next();
		});
	} 
	
	// 资源使用情况
	var autoChange, autoFlag = true;
	var promptPic1 = $(".promptPic1");
	var promptPic2 = $(".promptPic2");
	$(".secOpen").click(function(){
		$(".promptBg").show();
		$(".prompt-box").show();
		autoChange = setInterval(function(){ 
	        changeTo(autoFlag);  
	    }, 1000);
	});
	$(".prompt-close").click(function(){
		$(".promptBg").hide();
		$(".prompt-box").hide();
		clearInterval(autoChange);
	});
	function changeTo(flag){
		if(flag){
			promptPic1.hide();
			promptPic2.show();
			autoFlag = false;
		}else{
			promptPic2.hide();
			promptPic1.show();
			autoFlag = true;
		}
	}
	
	//初始化toastr弹出框位置
	toastr.options.positionClass = 'toast-top-right';
    //禁止浏览器的回退键
//    if (window.history && window.history.pushState) {
//        $(window).on('popstate', function () {
//                window.history.pushState('forward', null, '#');
//                window.history.forward(1);
//        });
//    }
//    window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
//    window.history.forward(1);
});

