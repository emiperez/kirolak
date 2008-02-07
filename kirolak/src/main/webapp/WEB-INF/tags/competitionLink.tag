<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="competition" required="true" type="com.kirolak.Competition" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="competition.jsp">
			<c:param name="id" value="${competition.seoName}-${competition.id}"></c:param>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${competition.name}"/></jsp:body>
</jsp:element>
