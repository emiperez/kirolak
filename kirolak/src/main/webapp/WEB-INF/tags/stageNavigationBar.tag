<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="stage" required="true" type="com.kirolak.Stage" %> 
<k:competitionNavigationBar competition="${stage.competition}" /> &gt; <k:stageLink stage="${stage}" />