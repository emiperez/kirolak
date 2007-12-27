<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
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
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" />
		&gt;
		<h:commandLink id="groups_link" action="groups" immediate="true">
			<h:outputFormat value="#{msg.group_teams_title}">
				<f:param value="#{group.parent.name}" />
				<f:param value="#{msg.groups}" />
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