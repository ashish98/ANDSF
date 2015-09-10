/**
 * author punit.j.patel
 * This Js file contains application's ajax functions
 */



/*This ajax function check dulicate name in Database*/
function verifyInstanceName(urlName, name, modelName, id){
	if($("div#"+modelName).length > 0){
		$("div#"+modelName).empty();
	}else{
		$('<div/>', {
		    id: modelName
		}).appendTo(name.parent());
	}
	 
	if($.trim(name.val()).length == 0 ) {
		$("#"+modelName).html("<label class='error'>Name is required</lable>");
		return false;
    } 
	/*clear server error*/
	name.parent().find("ul").remove();
	name.parent().find("div.errorMessage").remove();
	$.ajax({
		url : urlName,
		type: "POST",
		dataType: 'json',
		data:{
			modelName : $.trim(modelName) ,
			name : $.trim(name.val()),
			id : $.trim(id)
		},
		beforeSend : function(){
			var imgSrc = getWebInPath()+"/images/ajax-loader.gif";
			$("#"+modelName).html("<img src='"+imgSrc+"'/>");
		},
		success: function(data) {
			var response = eval(data);
//			console.log("Response Code="+response.resultCode);
			if(response.resultCode == 200 ) {
				var imgSrc = getWebInPath()+"/images/tick.jpg";
				$("#"+modelName).html("<img src='"+imgSrc+"'/>"+response.msg);
				$("#"+modelName).attr("class","ajaxValid");
				setVerifyInstance(true);
			}else {
				var imgSrc = getWebInPath()+"/images/cross.jpg";
				$("#"+modelName).html("<img src='"+imgSrc+"'/>");
				$("#"+modelName).append("<label class='error'>"+response.msg+"</lable>");
				setVerifyInstance(false);
			}  
		},
		error: function(e, x, settings, exception) {
			handleAjaxError(e, x, settings, exception, name);
		}
	}); 
}



function checkPattern(url , name,  modelName, id) {
	alert("check p");
	alert(name);
	
	if($.trim(name.val()).length == 0 ) {
		alert("in tr");
		$("#"+name).html("<label class='error'>Name is required</lable>");
		return false;
    } 
	alert("qaq");
	$.ajax({
		url : url,
		type: "POST",
		dataType: 'json',
		data:{
			name : $.trim(name.val()),
		},
		beforeSend : function(){
			alert("bs");
			var imgSrc = getWebInPath()+"/images/ajax-loader.gif";
			$("#"+name).html("<img src='"+imgSrc+"'/>");
		},
		success: function(data) {
			alert("sss");
			var response = eval(data);
//			console.log("Response Code="+response.resultCode);
			if(response.resultCode == 200 ) {
				var imgSrc = getWebInPath()+"/images/tick.jpg";
				$("#"+modelName).after("<img src='"+imgSrc+"' class='ajaxValidation'/>"+"<label class='ajaxValid ajaxValidation'>"+response.msg+"</label>");
				setVerifyInstance(true);
			}else {
				var imgSrc = getWebInPath()+"/images/cross.jpg";
				$("#"+modelName).html("<img src='"+imgSrc+"'/>");
				$("#"+modelName).append("<label class='error'>"+response.msg+"</lable>");
				setVerifyInstance(false);
			}  
		},
		error: function(e, x, settings, exception) {
			handleAjaxError(e, x, settings, exception, name);
		}
	}); 
	
}



function selectall(){
	form = document.displayform;
	if (form.ids != null) { 
		
		len = form.ids.length;
		if(len == undefined){
			if (form.check1.checked)	
				form.ids.checked=true ; 
			else 
				form.ids.checked=false ;
		}else{
			for(i=0; i<len;i++){  
				if (form.check1.checked && !form.ids[i].disabled)
					form.ids[i].checked=true ; 
				else 
					form.ids[i].checked=false ;
			} 
		}
	} 
} 

function handleAjaxError(e, x, settings, exception, name) {
	var message;
	var statusErrorMap = {
			'400' : "Server understood the request but request content was invalid.",
			'401' : "Unauthorised access.",
			'403' : "Forbidden resouce can't be accessed",
			'500' : "Internal Server Error.",
			'503' : "Service Unavailable"
	};
	if (x.status) {
		message =statusErrorMap[x.status];
		if(!message){
			message="Unknow Error \n.";
		}
	}else if(e=='parsererror'){
		message="Error.\nParsing JSON Request failed.";
	}else if(e=='timeout'){
		message="Request Time out.";
	}else if(e=='abort'){
		message="Request was aborted by the server";
	}else {
		message="Unknow Error \n.";
	}
	$(name).css("display","inline");
	$(name).append(message);
}

var verifyInstance = true;
function setVerifyInstance(isVerify) {
	verifyInstance = isVerify;
}
function isVerifyInstance(){
	return verifyInstance;
}

var verifyPattern = false;

function setVerifyPattern(isVerify) {
	verifyPattern = isVerify;
}
function isVerifyPattern(){
	return verifyPattern;
}
