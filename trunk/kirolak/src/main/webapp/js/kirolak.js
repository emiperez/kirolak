
	function widthChange()
	{
		document.getElementById("content").style.width = (document.body.offsetWidth - 330) + "px";
	}

	function changeRound(groupId,roundSelect)
	{
		alert(roundSelect);
		document.location = 'round.jsp?round='+groupId+'-'+roundSelect.options[roundSelect.selectedIndex].value;
	}