<%@tag trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>

<table class="match">
<tr>
<td class="match_day_time">
	<fmt:formatDate value="${match.dayTime}" type="both" dateStyle="full" timeStyle="short"/>
</td>
<td class="home_team">
	<k:teamLink team="${match.homeTeam}"></k:teamLink>
</td>
	<td class="score_home">
	${match.homeTeamScore}
	</td>
	<td class="score_separator">
	-
	</td>
	<td class="score_visiting">
	${match.visitingTeamScore}
	</td>
</td>
<td class="visiting_team">
	<k:teamLink team="${match.visitingTeam}"></k:teamLink>
</td>
</tr>
</table>