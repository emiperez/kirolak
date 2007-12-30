<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
	<html>
	
	<f:view>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputText value="#{round.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>	
	
	</head>

	<body onload="setFocus('saveRound:name','${errorField}');">
	<h:form id="saveRound">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports"value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="competitions_link" action="competitions" immediate="true">
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt; 
		<h:commandLink id="groups_link" action="groups" immediate="true">
			<h:outputFormat value="#{msg.groups_title}">
				<f:param value="#{group.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt; 
		<h:commandLink id="rounds_link" action="rounds" immediate="true">
			<h:outputFormat value="#{msg.rounds_title}">
				<f:param value="#{round.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputText value="#{round.title}" />
		</div>
		
		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.round}" />
			<h:inputText id="id" value="#{round.item.compositeId.id}" size="3"
				required="true">
			</h:inputText>
			<h:message id="idError" for="id" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.date}" />
			<h:inputText id="day" value="#{round.item.day}" size="12" required="true">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
			<h:message id="dayError" for="day" styleClass="error" />

		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{round.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
	</h:form>
	</body>	
	</f:view>
	</html>