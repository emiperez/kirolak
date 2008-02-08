<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="/" />
	</jsp:attribute>
	<jsp:body><fmt:message key="home"/></jsp:body>
</jsp:element>
