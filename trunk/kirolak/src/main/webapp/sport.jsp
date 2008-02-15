<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>


<jsp:useBean id="results" class="com.kirolak.jsp.beans.resultsBean"/>

<jsp:setProperty name="results" property="sportSeoName" param="id"/> 

<c:set var="title">${results.sport.name}</c:set>
<c:set var="lastResults" value="${results.lastResults}"/>

<k:head title="${title}"></k:head>


<div id="nav_bar"><k:homeLink/> &gt; <k:sportNavigationBar sport="${results.sport}"></k:sportNavigationBar> </div>

<k:widgets node="${results.sport}" />

<div id="content">
<k:results list="${lastResults}"></k:results>
</div>


