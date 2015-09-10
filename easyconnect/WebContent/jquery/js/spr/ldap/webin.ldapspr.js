function initSetUp(){
	
	 $('#addMapping').click(function(){
         $("#mappingTable tr:last").after("<tr>"+$("#templateTable").find("tr").html()+"</tr>");
         autoCompleteForClass('sprKeyClass',sprAutoCompleteArray);
     });
	 
	 autoCompleteForClass('sprKeyClass',sprAutoCompleteArray);
	 
	 $("#ldapSPRInstanceForm").submit(function(){
		 var isValidKey = true;
		
		$("#ldapSPRInstanceForm input[name='logicalName']").each(function(index ,item){
			var ldapValue = $.trim(item.value);
			if(ldapValue.length == 0) {
				isValidKey = false;
				var message = logicalNameProperty + " must specified";
				alert(message);
				$(this).focus();
				return false;
			}
		});	
		if(!isValidKey) {
			return false;
		}
		$("#ldapSPRInstanceForm input[name='dbField']").each(function(index ,item){
			var ldapValue = $.trim(item.value);
			if(ldapValue.length == 0) {
				isValidKey = false;
				var message = dbFieldProperty + " must specified";
				alert(message);
				$(this).focus();
				return false;
			}
		});	
		if(!isValidKey) {
			return false;
		}
		if(!isVerifyInstance()) {
			$("#sprInstanceData_name").focus();
			return false;
		}
		
	});
 	
}