<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="title" required="true"%>
<head>
<fmt:setLocale scope="request" value="en-US" />
<title>${title} - KirolaK</title>
<link href="css/kirolak.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

<script type="text/javascript" src="js/kirolak.js"></script>

</head>
<body onResize="widthChange()" onLoad="widthChange()">
<div id="header">
<div id="banner"></div>
</div>