<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>
<c:set var="lastResults" value="${results.lastResults}"/>

<c:set var="title"><fmt:message key="sports"></fmt:message></c:set>
<k:head title="${title}"></k:head>

<div id="nav_bar"><k:homeLink/></div>
<k:widgets  />
<div id="content">
<k:results list="${lastResults}"></k:results>
</div>

