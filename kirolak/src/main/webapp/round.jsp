<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>

<jsp:setProperty name="results" property="roundId" param="round"/> 

<c:set var="title">${results.round.number}</c:set>
<c:set var="roundResults" value="${results.roundResults}"/>

<k:head title="${title}"></k:head>


<div id="nav_bar"><k:homeLink/> &gt; <k:roundNavigationBar round="${results.round}" /> </div>

<k:widgets node="${results.round}" />

<div id="content">
<div id="results" class="content">
<table>
<tr>
<td>
<k:roundNavigator round="${results.round}"></k:roundNavigator>
<c:forEach items="${roundResults}" var="match">
	<k:match match="${match}" />
</c:forEach>
</td>
</tr>
</table>
</div>
<k:standings round="${results.round}" />
</div>


