<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="list" required="true" type="java.util.ArrayList" %>
<div id="results" class="content">
	<ul>
	<c:forEach items="${list}" var="match">
			<k:updatedMatch match="${match}" />
	</c:forEach>
	</ul>
</div>