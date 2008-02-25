<%@tag trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="stage" required="true" type="com.kirolak.Stage" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="stage.jsp">
			<c:param name="id" value="${stage.seoName}-${stage.id}"></c:param>
			<c:if test="${!empty param.l}">
				<c:param name="l" value="${param.l}"></c:param>
			</c:if>
		</c:url>
	</jsp:attribute>
	<jsp:body><c:out value="${stage.name}"/></jsp:body>
</jsp:element>
