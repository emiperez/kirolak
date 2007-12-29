<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>
		<h:outputFormat value="#{msg.groups_title}">
			<f:param value="#{group.parent.name}"/>
		</h:outputFormat>
	</title>	
	<link href="css/forms.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
	<h:form id="group-teams">
	
	<div class="navigation_bar">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" />
		 &gt; 
		 <h:commandLink id="competitions_link" action="competitions"
			immediate="true">
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		 &gt;  
		 <h:commandLink id="stages_link" action="stages"
			immediate="true">
			<h:outputFormat value="#{msg.stages_title}">
				<f:param value="#{stage.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:commandLink id="groups_link" action="groups" immediate="true">
			<h:outputFormat value="#{msg.groups_title}">
				<f:param value="#{group.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt; 
		<h:outputFormat value="#{msg.group_teams_title}">
			<f:param value="#{group.item.name}"/>
			<f:param value="#{msg.teams}" />
		</h:outputFormat>
	</div>
	<h:selectManyCheckbox value="#{group.selectedTeams}" layout="pageDirection">
		<f:converter converterId="kirolak.teamConverter"/>
		<f:selectItems value="#{group.selectItemsTeams}" />
	</h:selectManyCheckbox>
		<h:commandButton value="#{msg.save}" action="#{group.saveTeams}" />
		<h:commandButton value="#{msg.cancel}" action="groups" immediate="true" />
	</h:form>
	</body>
	</html>
</f:view>