/**
 * author punit.j.patel
 * This Js file contains application's common java script function
 */


/*this function remove row on click od  delete class image*/
$('table td img.delete').live('click',function() {			
	$(this).parent().parent().remove();
});	

function isNumberKey(evt,key){	
	var charCode = (evt.which) ? evt.which : event.keyCode;    
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
    	addError(key,"Only Numbers allows.");
    	return false;	
    }
    return true;
}