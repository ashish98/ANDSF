/**
 * This Js file contains auto complete features functions
 * This js must be import after jquery file
 */

function makeAutoCompleteAJAXRequest(datasourcename,tablename,suggestionArray,url){		
	$.ajax({
	    url: url,
	    dataType: "json",
	    type: "POST",	                
	    data:{
			tablename : $.trim(tablename) ,
			datasourcename : $.trim(datasourcename)
	    },
	    success: function (data) {	                	
	    	$.each(data, function(key, val) {
	    		var item = new ListItem(val,val);
	    		suggestionArray.push(item);            		
	    	});
	    },            
	    error: function (request, status, error) {
            console.log(request.responseText);
        }
	});
}

function ListItem(value,label) {
	this.value = value;
	this.label = label;
}

function autoCompleteForID(componentID,sourceArray){
	$("#"+componentID).autocomplete({
		minLength: 0,
		source: sourceArray,
		focus: function( event, ui ) {
			$( "#"+ componentID ).val( ui.item.value );
			return false;
		},
		select: function( event, ui ) {
			$( "#"+ componentID ).val( ui.item.value );
			return false;
		}
	});
}

function autoCompleteForClass(componentClass,sourceArray){
	$("."+componentClass).autocomplete({
		minLength: 0,
		source: sourceArray,
		focus: function( event, ui ) {
			$(this).val( ui.item.value );
			return false;
		},
		select: function( event, ui ) {
			$(this).val( ui.item.value );
			return false;
		}
	});
}
