<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="resultsBean" class="com.kirolak.jsp.beans.resultsBean"/>

<jsp:setProperty name="resultsBean" property="seoId" param="team"/>
<c:if test="${!empty param.page}">
	<jsp:setProperty name="resultsBean" property="page" param="page"/>
</c:if> 

<c:set var="title">${resultsBean.team.name}</c:set>
<c:set var="lastResults" value="${resultsBean.lastResults}"/>

<k:head title="${title}"></k:head>


<div id="nav_bar"><k:homeLink/> &gt; <k:teamNavigationBar team="${resultsBean.team}" /> </div>

<k:widgets node="${resultsBean.team}" />

<div id="content">
<k:results list="${lastResults}"></k:results>
</div>


