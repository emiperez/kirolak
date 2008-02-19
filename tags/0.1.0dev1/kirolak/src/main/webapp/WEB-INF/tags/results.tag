<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="list" required="true" type="java.util.ArrayList" %>

<div id="results" class="content">
	<h1><fmt:message key="last_updates"/></h1>
	<c:forEach items="${list}" var="match">
			<k:updatedMatch match="${match}" />
	</c:forEach>
</div>