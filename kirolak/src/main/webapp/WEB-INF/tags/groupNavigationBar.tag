<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="group" required="true" type="com.kirolak.Group" %> 
<k:stageNavigationBar stage="${group.stage}" /> &gt; <k:groupLink group="${group}" />