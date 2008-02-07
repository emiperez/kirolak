<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="list" required="true" type="java.util.ArrayList" %>
<div id="sports" class="widget">
	<ul>
	<c:forEach items="${list}" var="sport">
		<li>
			<k:sportLink sport="${sport}" />
		</li>
	</c:forEach>
	</ul>
</div>