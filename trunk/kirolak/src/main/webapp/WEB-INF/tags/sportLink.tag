<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="sport" required="true" type="com.kirolak.Sport" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="sport.jsp">
			<c:param name="id" value="${sport.seoName}"></c:param>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${sport.name}"/></jsp:body>
</jsp:element>
