<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="mode" required="false" %>
<%@ attribute name="round" required="true" type="com.kirolak.Round"%>

<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>
<jsp:setProperty property="round" name="results" value="${round}"/>

<c:set var="list" value="${results.standings}"/>
<table id="standings">
	<tr>
		<td colspan="2"></td>
		<td class="standing_group" colspan="7">
			<fmt:message key="total"/>
		</td>
		<td class="standing_group" colspan="7">
			<fmt:message key="home"/>
		</td>
		<td class="standing_group" colspan="7">
			<fmt:message key="visiting"/>
		</td>
	</tr>
	<tr id="standings_headers">
		<td class="numeric_column_header"></td>
		<td>
			<fmt:message key="team"/>
		</td>
		<!-- TOTAL -->
		<td class="numeric_column_header">
			<fmt:message key="games_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="won_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="drawn_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="lost_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="scored_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="received_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="points_abbr"/>
		</td>
		<!-- HOME -->
		<td class="numeric_column_header">
			<fmt:message key="games_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="won_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="drawn_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="lost_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="scored_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="received_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="points_abbr"/>
		</td>
		<!-- VISITING -->
		
		<td class="numeric_column_header">
			<fmt:message key="games_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="won_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="drawn_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="lost_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="scored_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="received_abbr"/>
		</td>
		<td class="numeric_column_header">
			<fmt:message key="points_abbr"/>
		</td>
	</tr>
	<c:set var="counter" value="0"/>
	<c:forEach items="${list}" var="row">
		<tr id="standings_row">			
			<c:set var="counter" value="${counter+1}"/>
			<td class="numeric_column">
			${counter}
			</td>
			<td>
				<k:teamLink team="${row.id.team}"></k:teamLink>
			</td>
			<!-- TOTAL -->
			<td class="numeric_column">
				${row.games}
			</td>
			<td class="numeric_column">
				${row.wonGames}
			</td>
			<td class="numeric_column">
				${row.drawnGames}
			</td>
			<td class="numeric_column">
				${row.lostGames}
			</td>
			<td class="numeric_column">
				${row.scoreTotal}
			</td>
			<td class="numeric_column">
				${row.scoreAgainstTotal}
			</td>
			<td class="standing_points">
				${row.teamPoints}
			</td>
			<!-- HOME -->
			<td class="numeric_column">
				${row.gamesHome}
			</td>
			<td class="numeric_column">
				${row.wonHome}
			</td>
			<td class="numeric_column">
				${row.drawnHome}
			</td>
			<td class="numeric_column">
				${row.lostHome}
			</td>
			<td class="numeric_column">
				${row.scoreHome}
			</td>
			<td class="numeric_column">
				${row.scoreAgainstHome}
			</td>
			<td class="standing_points">
				${row.homePoints}
			</td>
			
			<!-- VISITING -->
			<td class="numeric_column">
				${row.gamesVisiting}
			</td>
			<td class="numeric_column">
				${row.wonVisiting}
			</td>
			<td class="numeric_column">
				${row.drawnVisiting}
			</td>
			<td class="numeric_column">
				${row.lostVisiting}
			</td>
			<td class="numeric_column">
				${row.scoreVisiting}
			</td>
			<td class="numeric_column">
				${row.scoreAgainstVisiting}
			</td>
			<td class="standing_points">
				${row.visitingPoints}
			</td>
		</tr>
	</c:forEach>
</table>