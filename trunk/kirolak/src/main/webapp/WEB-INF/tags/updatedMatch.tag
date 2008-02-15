<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="match" required="true" type="com.kirolak.Match" %>

<li>
	<k:roundNavigationBar round="${match.round}" /><br/>
	<k:match match="${match}"/>
</li>