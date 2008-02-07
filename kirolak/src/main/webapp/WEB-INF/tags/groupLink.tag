<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="group" required="true" type="com.kirolak.Group" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="group.jsp">
			<c:param name="id" value="${group.name}-${group.id}"></c:param>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${group.name}"/></jsp:body>
</jsp:element>
