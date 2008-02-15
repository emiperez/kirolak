<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>

<%@ attribute name="node" type="com.kirolak.KirolakObject" required="false" %>

<div id="widgets">
	<c:if test="${empty node}">
		<jsp:useBean id="sps" class="com.kirolak.jsp.beans.sportsBean"/>
		<c:set var="sports" value="${sps.sports}" />		
		
		<c:if test="${fn:length(sports) == 1}">
			<c:set var="sport" value="${sports[0]}"/>
		</c:if>
	</c:if>
	<c:if test="${(!empty node) and node.class.simpleName == 'Sport'}">
		<c:set var="sport" value="${node}"/>
	</c:if>
	<c:if test="${!empty sport}">
		<jsp:useBean id="comps" class="com.kirolak.jsp.beans.competitionsBean"/>		
		<jsp:setProperty name="comps" property="sport" value="${sport}"/>
		<k:competitions list="${comps.competitions}"></k:competitions>
	</c:if>
	
</div>