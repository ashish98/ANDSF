/**
 * author punit.j.patel
 * This Js file is use for struts2 client side validation
 * original validation file is override for override error message.
 * default struts 2 validation.js file rename as struts2_validation.js.
 */

function addError(e, errorText) {
	try {
		if($(e).parent().find("label.error").length > 0) {
			return false;
		}
		$(e).parent().find(".ajaxValid").remove();
		
		var divId = "struts_"+$(e).attr("id");
		if($("#"+divId).length > 0) {
			return false;
		}
		$('<div/>', {
		    id: divId
		}).appendTo($(e).parent());
		
		$("#"+divId).append("<label class='error'>"+errorText+"</lable>")
					 .attr("class", "errorMessage");
	} catch (err) {
        alert(err);
    }
}
function clearErrorMessages(form){
	$("div.errorMessage").remove();
}

function clearErrorLabels(form){
	
}


