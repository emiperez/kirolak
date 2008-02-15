<%@ attribute name="title" required="true"%>
<head>
<c:set var="title" value="KirolaK"></c:set>
<title>${title} - KirolaK</title>
<link href="css/kirolak.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

<script type="text/javascript">
	function widthChange()
	{
		document.getElementById("content").style.width = (document.body.offsetWidth - 330) + "px";
	}
</script>

</head>
<body onResize="widthChange()" onLoad="widthChange()">
<div id="header">
<div id="banner"></div>
</div>