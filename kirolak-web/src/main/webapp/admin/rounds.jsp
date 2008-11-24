<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputFormat value="#{msg.rounds_title}">
		<f:param value="#{round.parent.name}" />
	</h:outputFormat></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<h:form id="rounds">

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
		 <h:outputFormat value="#{msg.rounds_title}">
			<f:param value="#{round.parent.name}" />
		</h:outputFormat></div>

		<h:commandButton action="#{round.newItem}" value="#{msg.new}" />
		<h:commandButton action="#{round.auto}" value="#{msg.auto}" rendered="#{round.lines == 0}" />
		<h:dataTable value="#{round.items}" var="item"
			binding="#{round.itemData}" rowClasses="row">
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.name}" />
				</f:facet>
				<h:outputText value="#{item.compositeId.id}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.date}" />
				</f:facet>
				<h:outputText value="#{item.day}">			
					<f:convertDateTime dateStyle="full"/>
				</h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.matches}" />
				</f:facet>
				<h:dataTable value="#{item.matches}" var="match">
					<h:column>
						<h:outputText value="#{match.homeTeam.acronym}" />
					</h:column>					
					<h:column>
						<h:outputText value="#{match.homeTeamScore}" />
					</h:column>										
					<h:column>
						<h:outputText value=" - " />
					</h:column>
					<h:column>
						<h:outputText value="#{match.visitingTeamScore}" />
					</h:column>
					<h:column>
						<h:outputText value="#{match.visitingTeam.acronym}" />
					</h:column>
				</h:dataTable>
			</h:column>
			<h:column>
				<h:commandButton id="edit" action="#{round.editItem}"
					value="#{msg.edit}" />
			</h:column>
			<h:column>
				<h:commandButton id="delete" action="#{round.deleteItem}"
					onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
			</h:column>
		</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>