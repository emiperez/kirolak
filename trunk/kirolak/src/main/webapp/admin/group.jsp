<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
	<html>
	
	<f:view>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputText value="#{group.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>	
	
	</head>

	<body onload="setFocus('saveGroup:name','${errorField}');">
	<h:form id="saveStage">
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
		<h:outputText value="#{group.title}" />
		</div>
		
		<h:inputHidden id="id" value="#{group.item.id}" />
		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{group.item.name}" size="25"
				required="true">
				<f:validateLength maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{group.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
	</h:form>
	</body>	
	</f:view>
	</html>