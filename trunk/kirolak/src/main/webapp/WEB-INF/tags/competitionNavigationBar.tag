<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="competition" required="true" type="com.kirolak.Competition" %> 
<k:sportNavigationBar sport="${competition.sport}" /> &gt; <k:competitionLink competition="${competition}" />