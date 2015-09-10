$(document).ready(function(){
	$(function() {
		$(".menu").click( function() {
			$('.menu-selected').attr('class','menu');
			$(this).attr("class","menu-selected");			
		});			
	});
	$(function() {
		$(".menu-last").click( function() {
			$('.menu-selected').attr('class','menu');
			$(this).attr("class","menu-selected");				
		});			
	});
});