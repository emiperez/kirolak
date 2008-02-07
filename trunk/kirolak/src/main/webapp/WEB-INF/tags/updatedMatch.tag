<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>


			<li><k:sportLink sport="${match.round.group.stage.competition.sport}"/></li>

<table class="match">
<tr>
<td class="match_day_time">
	<fmt:formatDate value="${match.dayTime}" type="both" dateStyle="full" timeStyle="short"/>
</td>
<td class="match_team">
	<k:teamLink team="${match.homeTeam}"></k:teamLink>
</td>
<td class="score">
	${match.homeTeamScore}
</td>
<td class="score_separator">
	-
</td>
<td class="score">
	${match.visitingTeamScore}
</td>
<td class="match_team">
	<k:teamLink team="${match.visitingTeam}"></k:teamLink>
</td>
</tr>
</table>
