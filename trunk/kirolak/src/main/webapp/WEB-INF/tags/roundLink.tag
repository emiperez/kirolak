<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="round" required="true" type="com.kirolak.Round" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="round.jsp">
			<c:param name="round" value="${round.group.id}-${round.number}"/>
		</c:url>
	</jsp:attribute>
	<jsp:body>
		<fmt:message key="round_name">
			<fmt:param>${round.number}</fmt:param>
		</fmt:message>
	</jsp:body>
</jsp:element>
