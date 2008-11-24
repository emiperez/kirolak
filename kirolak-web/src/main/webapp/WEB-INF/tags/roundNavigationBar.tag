<%@tag trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="k" %>
<%@ attribute name="round" required="true" type="com.kirolak.Round" %> 
<k:groupNavigationBar group="${round.group}" /> &gt; <k:roundLink round="${round}" />
