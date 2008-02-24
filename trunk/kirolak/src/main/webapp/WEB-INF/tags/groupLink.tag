<%@tag trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="group" required="true" type="com.kirolak.Group" %>
<jsp:element name="a">	
	<jsp:attribute name="href">
		<c:url value="group.jsp">
			<c:param name="group" value="${group.name}-${group.id}"></c:param>
			<c:if test="${!empty param.l}">
				<c:param name="l" value="${param.l}"></c:param>
			</c:if>
		</c:url>
	</jsp:attribute>
	<jsp:body>
		<fmt:message key="group_name">
			<fmt:param>${group.name}</fmt:param>
		</fmt:message>
	</jsp:body>
</jsp:element>
