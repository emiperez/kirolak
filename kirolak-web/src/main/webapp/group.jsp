<jsp:useBean id="roundsBean" class="com.kirolak.jsp.beans.roundsBean"/>
<jsp:setProperty property="seoId" name="roundsBean" param="group" />
<jsp:forward page="round.jsp">
	<jsp:param value="${roundsBean.group.id}-${roundsBean.currentRound.number}" name="round"/>
</jsp:forward>