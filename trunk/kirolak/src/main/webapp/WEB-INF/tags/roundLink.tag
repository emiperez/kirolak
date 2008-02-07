<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="round" required="true" type="com.kirolak.Round" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="round.jsp">
			<c:param name="id" value="${round.roundId.group.id}-${round.seoName}"></c:param>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${round.id} .- ${round.day}"/></jsp:body>
</jsp:element>
