/**
 * Provide Java Script functions for DB SPR 
 * 
 */

var tableNameArray = new Array();
var columnNameArray = new Array();
var sprAutoCompleteArray = new Array();

function initSetUp() {
	$('#addMapping').click(function(){
         $("#mappingTable tr:last").after("<tr>"+$("#templateTable").find("tr").html()+"</tr>");
         autoCompleteForClass('dbField',columnNameArray);
         autoCompleteForClass('logicalName',sprAutoCompleteArray);
    });
	
	$("#dbSprInstance_datasourcename").change(function(){
		applyTableSuggestion();
	});
	
	$("#dbSprInstance_tablename").blur(function(){
		applyColumnSuggestion();
	});
	
	applyTableSuggestion();
	applyColumnSuggestion();
	
	$("#dbsprinstanceform").submit(function(){
		if(!isVerifyInstance()) {
			$("#sprInstanceData_name").focus();
			return false;
		}
	});
	
}


function applyTableSuggestion(){
	var datasourceName = $.trim($('#dbSprInstance_datasourcename').val());
	if(datasourceName.length > 0) {
		makeAutoCompleteAJAXRequest(datasourceName,"",tableNameArray,"tableNameAutoComplete.do");
		autoCompleteForID('dbSprInstance_tablename',tableNameArray);
	}
}

function applyColumnSuggestion() {
	var datasourceName = $.trim($('#dbSprInstance_datasourcename').val()); 
	var tableName = $.trim($('#dbSprInstance_tablename').val());
	if(datasourceName.length > 0 && tableName.length > 0 ) {
		makeAutoCompleteAJAXRequest(datasourceName,tableName,columnNameArray,"columnNameAutoComplete.do");
		autoCompleteForID('dbsprInstance_identitycolumn',columnNameArray);
		autoCompleteForClass('dbField',columnNameArray);
	}
}

