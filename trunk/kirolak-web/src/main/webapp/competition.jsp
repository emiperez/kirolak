<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>

<jsp:setProperty name="results" property="seoId" param="id"/> 

<c:set var="title">${results.competition.name}</c:set>
<c:set var="lastResults" value="${results.lastResults}"/>

<k:head title="${title}"></k:head>


<div id="nav_bar"><k:homeLink/> &gt; <k:competitionNavigationBar competition="${results.competition}"/> </div>

<k:widgets node="${results.competition}" />

<div id="content">
<k:results list="${lastResults}"></k:results>
</div>


