<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="team" required="true" type="com.kirolak.Team" %> 
<k:sportNavigationBar sport="${team.sport}" /> &gt; <k:teamLink team="${team}" />