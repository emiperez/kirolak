<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="team" required="true" type="com.kirolak.Team" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="team.jsp">
			<c:param name="team" value="${team.seoName}-${team.id}"></c:param>
			<c:if test="${!empty param.l}">
				<c:param name="l" value="${param.l}"></c:param>
			</c:if>
		</c:url>
	</jsp:attribute>	
	<jsp:body><c:out value="${team.name}"/></jsp:body>
</jsp:element>
