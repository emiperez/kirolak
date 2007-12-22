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