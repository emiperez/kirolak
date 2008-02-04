<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sp" %>
<jsp:useBean id="sps" class="com.kirolak.jsp.beans.sportsBean"/>
<c:set var="sports" value="${sps.sports}" />
<c:if test="${fn:length(sports) > 0}">
	<div id="sports" class="widget">
		<ul>
		<c:forEach items="${sports}" var="sport">
			<li><sp:sportLink sport="${sport}" /></li>
		</c:forEach>
		</ul>
	</div>
</c:if>