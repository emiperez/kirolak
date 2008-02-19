<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>

<f:view>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><h:outputFormat value="#{msg.groups_title}">
		<f:param value="#{group.parent.name}" />
	</h:outputFormat></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>

	</head>

	<body onload="setFocus('groupGenerator:groupNumber','${errorField}');">
	<h:form id="groupGenerator">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="#{sport.load}" value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="competitions_link" action="#{competition.load}"	immediate="true">			
			<f:param name="parent" value="#{competition.parent.id}"/>
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;  
		<h:commandLink id="stages_link" action="#{stage.load}"	immediate="true">			
			<f:param name="parent" value="#{stage.parent.id}"/>
			<h:outputFormat value="#{msg.stages_title}">
				<f:param value="#{stage.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;  
		<h:commandLink id="groups_link" action="#{group.load}"	immediate="true">			
			<f:param name="parent" value="#{group.parent.id}"/>
			<h:outputFormat value="#{msg.groups_title}">
				<f:param value="#{group.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputFormat value="#{msg.groups_generator_title}">
			<f:param value="#{group.parent.name}" />
		</h:outputFormat></div>

		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.groups}" />
			<h:selectOneMenu id="groupNumber" value="#{group.groupNumber}">
				<f:selectItems value="#{group.groupGeneratorSelectItems}" />
			</h:selectOneMenu>
			<h:message id="nameError" for="name" styleClass="error" />
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{group.auto}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
	</h:form>
	</body>
</f:view>
</html>