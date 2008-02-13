<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>
<jsp:useBean id="sps" class="com.kirolak.jsp.beans.sportsBean"/>


<c:set var="sports" value="${sps.sports}" />

<jsp:setProperty name="results" property="sport" param="id"/> 
<c:set var="lastResults" value="${results.lastResults}"/>

<div id="nav_bar"><k:homeLink/></div>

<div id="widgets">
<c:choose>
<c:when test="${fn:length(sports) > 1}">
	<k:sports list="${sports}"/>
</c:when>
</c:choose>
</div>

<div id="content">
<k:results list="${lastResults}"></k:results>
</div>


