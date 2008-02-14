<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>

<li>
	<k:sportLink sport="${match.round.group.stage.competition.sport}"/><br/>
	<k:match match="${match}"/>
</li>