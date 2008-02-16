<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="mode" required="false" %>
<%@ attribute name="round" required="true" type="com.kirolak.Round"%>

<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>
<jsp:setProperty property="round" name="results" value="${round}"/>

<c:set var="list" value="${results.standings}"/>
<table id="standings">
	<tr id="standings_headers">
		<td id="standing_team_header">
			<fmt:message key="team"/>
		</td>
		<td id="standing_games_header">
			<fmt:message key="games_abbr"/>
		</td>
		<td id="standing_points_header">
			<fmt:message key="points_abbr"/>
		</td>
	</tr>
	<c:forEach items="${list}" var="row">
		<tr id="standings_row">
			<td class="standing_team">
				<k:teamLink team="${row.id.team}"></k:teamLink>
			</td>
			<td class="standing_games">
				${row.games}
			</td>
			<td class="standing_points">
				${row.teamPoints}
			</td>
		</tr>
	</c:forEach>
</table>