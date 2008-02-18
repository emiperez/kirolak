function setFocus(field_focus, error_field) {
	if(error_field != '')
	{
		field_focus = error_field;
	}
    var element = document.getElementById(field_focus);
    if (element && element.focus) {
        element.focus();
    }
}

function checkAll( master )
{ 
	var checked = master.checked;
	
	var col = document.getElementsByTagName("INPUT");
	for (var i=0;i<col.length;i++) {
		col[i].checked= checked;
	}
 
 
	var jsfForm = master.form;
	for( i=0; i< jsfForm.length; i++){
		if( jsfForm[i].type == 'checkbox' && jsfForm[i].id != master.id  ){
			jsfForm[i].checked = checked;
		}
	}	
}