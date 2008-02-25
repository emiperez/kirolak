
	function widthChange()
	{
		document.getElementById("content").style.width = (document.body.offsetWidth - 350) + "px";
	}

	function changeRound(groupId,roundSelect)
	{
		document.location = 'round.jsp?round='+groupId+'-'+roundSelect.options[roundSelect.selectedIndex].value;
	}