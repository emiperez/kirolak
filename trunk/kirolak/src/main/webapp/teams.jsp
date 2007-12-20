<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<title><h:outputText value="#{team.parent.name} #{msg.teams}" /></title>
	</head>

	<body>
	<h:form id="teams">
	<h:commandLink action="#{team.newItem}" value="#{msg.new}"/>
	<h:dataTable value="#{team.items}" var="item"
			binding="#{team.itemData}">
		<f:param name="teamId" value="#{item.id}" />	
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
			<h:commandLink id="edit" action="#{team.editItem}"><h:outputText value="#{msg.edit}" /></h:commandLink>
		</h:column>
		<h:column>
			<h:commandLink id="delete" action="#{team.deleteItem}" onclick="return confirm('#{msg.sure}')"><h:outputText value="#{msg.delete}" /></h:commandLink>
		</h:column>
	</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>