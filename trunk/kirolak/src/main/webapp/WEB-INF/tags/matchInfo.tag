<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>

<jsp:element name="a">
	<jsp:attribute name="href">
		<c:url value="sport.jsp">
			<c:param name="id" value="${match.round.group.stage.competition.sport.seoName}"></c:param>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${sport.name}"/></jsp:body>
</jsp:element>
