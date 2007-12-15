<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<title><h:outputText value="#{sport.name} - #{msg.teams}" /></title>
	</head>

	<body>
	<h:form id="sports">
	<h:commandLink action="newTeam" value="#{msg.new}"/>
	<h:dataTable value="#{makeList.list[sport.teams]}" var="item" binding="#{team.teamData}">	
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.id}" />
			</f:facet>
			<h:outputText value="#{item.id}" />
		</h:column>
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
			<h:commandLink id="edit" action="#{team.edit}"><h:outputText value="#{msg.edit}" /></h:commandLink>
		</h:column>
		<h:column>
			<h:commandLink id="delete" action="#{team.delete}" onclick="return confirm('#{msg.sure}')"><h:outputText value="#{msg.delete}" /></h:commandLink>
		</h:column>
	</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>