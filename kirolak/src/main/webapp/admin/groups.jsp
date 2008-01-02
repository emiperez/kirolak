<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputFormat value="#{msg.groups_title}">
		<f:param value="#{group.parent.name}" />
	</h:outputFormat></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<h:form id="groups">

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
		 <h:outputFormat value="#{msg.groups_title}">
			<f:param value="#{group.parent.name}" />
		</h:outputFormat></div>

		<h:commandButton action="#{group.newItem}" value="#{msg.new}" />
		<h:commandButton action="auto" value="#{msg.auto}" rendered="#{group.lines == 0}" />
		<h:dataTable value="#{group.items}" var="item"
			binding="#{group.itemData}" rowClasses="row">
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.name}" />
				</f:facet>
				<h:outputText value="#{item.name}" />
			</h:column>
			<h:column>
				<h:commandButton id="edit" action="#{group.editItem}"
					value="#{msg.edit}" />
			</h:column>
			<h:column>
				<h:commandButton id="delete" action="#{group.deleteItem}"
					onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
			</h:column>
			<h:column>
				<h:commandLink id="group-teams" action="#{group.teams}">
					<h:outputText value="#{msg.teams}" />
				</h:commandLink>
			</h:column>
			<h:column>
				<h:commandLink id="rounds" action="#{round.load}">
					<f:param name="parent" value="#{item.id}"/>
					<h:outputText value="#{msg.rounds}" />
				</h:commandLink>
			</h:column>
			
		</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>