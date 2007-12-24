<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<title>
		<h:outputFormat value="#{msg.competitions_title}">
			<f:param value="#{competition.parent.name}"/>
		</h:outputFormat>
	</title>	
	<link href="css/forms.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
	<h:form id="competitions">
	
	<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:outputFormat value="#{msg.competitions_title}">
			<f:param value="#{competition.parent.name}"/>
		</h:outputFormat>
	</div>
	
	<h:commandButton action="#{competition.newItem}" value="#{msg.new}"/>
	<h:dataTable value="#{competition.items}" var="item"
			binding="#{competition.itemData}" rowClasses="row">
		<f:param name="competitionId" value="#{item.id}" />	
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.name}" />
			</f:facet>
			<h:outputText value="#{item.name}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.seo_name}" />
			</f:facet>
			<h:outputText value="#{item.seoName}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.start_date}" />
			</f:facet>
			<h:outputText value="#{item.startDate}">
				<f:convertDateTime dateStyle="long"/>
			</h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.finish_date}" />
			</f:facet>
			<h:outputText value="#{item.finishDate}">				
				<f:convertDateTime dateStyle="long"/>
			</h:outputText>
		</h:column>
		<h:column>
			<h:commandButton id="edit" action="#{competition.editItem}" value="#{msg.edit}" />
		</h:column>
		<h:column>
			<h:commandButton id="delete" action="#{competition.deleteItem}" onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
		</h:column>
		<h:column>
				<h:commandLink id="teams" action="teams"
					actionListener="#{team.load}">
					<f:param name="parent" value="#{item.id}"/>
					<h:outputText value="#{msg.teams}" />
				</h:commandLink>
			</h:column>
			<h:column>
				<h:commandLink id="stages" action="stages"
					actionListener="#{stage.load}">
					<f:param name="parent" value="#{item.id}"/>
					<h:outputText value="#{msg.stages}" />
				</h:commandLink>
			</h:column>
	</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>