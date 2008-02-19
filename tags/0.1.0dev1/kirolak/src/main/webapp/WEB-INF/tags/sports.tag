<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k"%>

<%@ attribute name="list" required="true" type="java.util.ArrayList"%>

<div id="sports" class="widget">
	<div class="widget_title">
		<fmt:message key="sports" />
	</div>
	<div class="widget_content">
		<ul>
		<c:forEach items="${list}" var="sport">
			<li><k:sportLink sport="${sport}" /></li>
		</c:forEach>
		</ul>
	</div>
</div>