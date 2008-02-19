<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="round" required="true" type="com.kirolak.Round" %>

<jsp:useBean id="roundsBean" class="com.kirolak.jsp.beans.roundsBean"/>
<jsp:setProperty property="group" name="roundsBean" value="${round.group}" />
<c:set var="rounds" value="${roundsBean.rounds}"/>

<div class="round_navigator">
<form name="roundSelector">
<select name="round_select" class="roundSelect" onchange="changeRound(${round.group.id},this.form.round_select)">
<c:forEach items="${rounds}" var="currentRound">	
	<c:if test="${(selected) and (empty nextRound)}">
		<c:set var="nextRound" value="${currentRound}"/>
	</c:if>
	<c:if test="${currentRound.compositeId.id == round.compositeId.id}">
		<option value="${currentRound.compositeId.id}" selected="selected">
			<fmt:message key="round_name">
				<fmt:param>${currentRound.number}</fmt:param>
			</fmt:message>
		</option>
		<c:if test="${!empty tmpRound}">
			<c:set var="previousRound" value="${tmpRound}"/>
		</c:if>
		<c:set var="selected" value="${true}"/>
	</c:if>
	<c:if test="${currentRound.compositeId.id != round.compositeId.id}">
		<option value="${currentRound.compositeId.id}">
			<fmt:message key="round_name">
				<fmt:param>${currentRound.number}</fmt:param>
			</fmt:message>
		</option>
	</c:if>
	<c:set var="tmpRound" value="${currentRound}"/>	
</c:forEach>
</select>
<c:if test="${!empty previousRound}">
	&lt; <k:roundLink round="${previousRound}" />
</c:if>
<c:if test="${!empty nextRound}">
	<c:if test="${!empty previousRound}">
	 | 
	</c:if>
	<k:roundLink round="${nextRound}" /> &gt;
</c:if>
</form>
</div>