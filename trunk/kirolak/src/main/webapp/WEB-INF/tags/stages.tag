<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>

<%@ attribute name="list" required="true" type="java.util.ArrayList" %>

<div id="stages" class="widget">
	<div class="widget_title">
		<fmt:message key="stages"/>
	</div>
	<ul>
	<c:forEach items="${list}" var="stage">
		<li>
			<k:stageLink stage="${stage}" />
		</li>
	</c:forEach>
	</ul>
</div>