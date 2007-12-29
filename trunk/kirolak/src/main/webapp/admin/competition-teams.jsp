<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>
		<h:outputFormat value="#{msg.competitions_title}">
			<f:param value="#{competition.parent.name}"/>
		</h:outputFormat>
	</title>	
	<link href="css/forms.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
	<h:form id="competition-teams">
	
	<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" />
		&gt;
		<h:commandLink id="competitions_link" action="competitions" immediate="true">
			<h:outputFormat value="#{msg.competition_teams_title}">
				<f:param value="#{competition.parent.name}" />
				<f:param value="#{msg.competitions}" />
			</h:outputFormat>
		</h:commandLink>
		&gt; 
		<h:outputFormat value="#{msg.competition_teams_title}">
			<f:param value="#{competition.item.name}"/>
			<f:param value="#{msg.teams}" />
		</h:outputFormat>
	</div>
	<h:selectManyCheckbox value="#{competition.selectedTeams}" layout="pageDirection">
		<f:converter converterId="kirolak.teamConverter"/>
		<f:selectItems value="#{competition.selectItemsTeams}" />
	</h:selectManyCheckbox>
		<h:commandButton value="#{msg.save}" action="#{competition.saveTeams}" />
		<h:commandButton value="#{msg.cancel}" action="competitions" immediate="true" />
	</h:form>
	</body>
	</html>
</f:view>