$(function () {
	
	jQuery.support.placeholder = false;
	test = document.createElement('input');
	if('placeholder' in test) jQuery.support.placeholder = true;
	
	if (!$.support.placeholder) {
		
		$('.field').find ('label').show ();
		
	}
	
	
	
	$('#tjlabel1').delay(1200).addClass('animated bounceInLeft');
	$('#tjlabel2').delay(1200).addClass('animated bounceInLeft');
	$('#tjlabel3').delay(1200).addClass('animated bounceInRight');
	$('#tjlabel4').delay(1200).addClass('animated bounceInRight');
	
	
	
});