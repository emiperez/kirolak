<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>

<span class="match_day_time">
	<fmt:formatDate value="${match.dayTime}" type="both" dateStyle="medium" timeStyle="short"/>
</span>
<span class="match_team">
	<k:teamLink team="${match.homeTeam}"></k:teamLink>
</span>
<span class="score">
	${match.homeTeamScore}
</span>
<span class="score_separator">
	-
</span>
<span class="score">
	${match.visitingTeamScore}
</span>
<span class="match_team">
	<k:teamLink team="${match.visitingTeam}"></k:teamLink>
</span>