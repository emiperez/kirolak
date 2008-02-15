<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>

<%@ attribute name="list" required="true" type="java.util.ArrayList" %>

<div class="widget_title">
	<fmt:message key="competitions"/>
</div>
<div id="competitions" class="widget">
	<ul>
	<c:forEach items="${list}" var="competition">
		<li>
			<k:competitionLink competition="${competition}" />
		</li>
	</c:forEach>
	</ul>
</div>