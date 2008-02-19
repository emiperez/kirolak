<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>

<%@ attribute name="node" type="com.kirolak.KirolakObject" required="false" %>
<jsp:useBean id="comps" class="com.kirolak.jsp.beans.competitionsBean"/>

<c:set var="itemClass" value="${node.class.simpleName}"/>
<div id="widgets">
	<c:if test="${empty node}">
		<jsp:useBean id="sps" class="com.kirolak.jsp.beans.sportsBean"/>
		<c:set var="sports" value="${sps.sports}" />		
		<c:if test="${fn:length(sports) == 1}">
			<c:set var="sport" value="${sports[0]}"/>
		</c:if>
		<c:if test="${fn:length(sports) > 1}">
			<k:sports list="${sports}" />
		</c:if>
	</c:if>
	<c:if test="${(!empty node)}">
		<c:choose>
			<c:when test="${itemClass == 'Sport'}">			
				<c:set var="sport" value="${node}"/>
			</c:when>
			<c:when test="${itemClass == 'Competition'}">			
				<c:set var="competition" value="${node}"/>
			</c:when>
			<c:when test="${itemClass == 'Stage'}">			
				<c:set var="stage" value="${node}"/>
			</c:when>
			<c:when test="${itemClass == 'Group'}">			
				<c:set var="group" value="${node}"/>
			</c:when>
			<c:when test="${itemClass == 'Team'}">			
				<c:set var="team" value="${node}"/>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${!empty sport}">		
		<jsp:setProperty name="comps" property="item" value="${sport}"/>
		<c:set var="competitions" value="${comps.competitions}" />		
		<c:if test="${fn:length(competitions) == 1}">
			<c:set var="competition" value="${competitions[0]}"/>
		</c:if>
		<c:if test="${fn:length(competitions) > 1}">
			<k:competitions list="${competitions}" />
		</c:if>
	</c:if>
	<c:if test="${!empty competition}">
		<jsp:useBean id="stgs" class="com.kirolak.jsp.beans.stagesBean"/>		
		<jsp:setProperty name="stgs" property="competition" value="${competition}"/>
		<c:set var="stages" value="${stgs.stages}" />		
		<c:if test="${fn:length(stages) == 1}">
			<c:set var="stage" value="${stages[0]}"/>
		</c:if>
		<c:if test="${fn:length(stages) > 1}">
			<k:stages list="${stages}" />
		</c:if>
	</c:if>
	<c:if test="${!empty stage}">
		<jsp:useBean id="grps" class="com.kirolak.jsp.beans.groupsBean"/>		
		<jsp:setProperty name="grps" property="stage" value="${stage}"/>
		<c:set var="groups" value="${grps.groups}" />		
		<c:if test="${fn:length(groups) > 1}">
			<k:groups list="${groups}" />
		</c:if>
	</c:if>
	<c:if test="${!empty team}">
		<jsp:setProperty name="comps" property="item" value="${team}"/>
		<c:set var="competitions" value="${comps.competitions}" />		
		<c:if test="${fn:length(competitions) > 0}">
			<k:competitions list="${competitions}" />
		</c:if>
	</c:if>
	
</div>