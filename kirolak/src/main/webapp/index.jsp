<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>
<jsp:useBean id="sps" class="com.kirolak.jsp.beans.sportsBean"/>
<c:set var="sports" value="${sps.sports}" />
<c:set var="lastResults" value="${results.lastResults}"/>

<k:results list="${lastResults}"></k:results>
<c:choose>
<c:when test="${fn:length(sports) > 1}">
	<k:sports list="${sports}"/>
</c:when>
</c:choose>


