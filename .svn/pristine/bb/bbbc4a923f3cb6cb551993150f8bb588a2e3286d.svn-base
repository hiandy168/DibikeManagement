$(function(){
	size();

	$(window).on('scroll resize',function(){
		size();
	})

	function size(){
		var h=$(window).height();
		var sh=h-$('.header').height()-$('.footer').height();
		var ah=$('.menu_box').height();
		$('.section').css('minHeight',sh+'px');
		$('.main').css('minHeight',sh+'px');
		$('.section-box').css('minHeight',ah+'px');

	}

});