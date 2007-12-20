<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<title><h:outputText value="#{msg.sports}" /></title>
		<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body>
	<h:form id="sports">
		<h:commandLink action="#{sport.newItem}" value="#{msg.new}"/>
		<h:dataTable value="#{sport.items}" var="item"
			binding="#{sport.itemData}" rowClasses="row">
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
				<h:commandLink id="edit" action="#{sport.editItem}">
					<h:outputText value="#{msg.edit}" />
				</h:commandLink>
			</h:column>
			<h:column>
				<h:commandLink id="delete" action="#{sport.deleteItem}"
					onclick="return confirm('#{msg.sure}')">
					<h:outputText value="#{msg.delete}" />
				</h:commandLink>
			</h:column>
			<h:column>
				<h:commandLink id="teams" action="teams"
					actionListener="#{team.load}">
					<f:param name="parent" value="#{item.id}"/>
					<h:outputText value="#{msg.teams}" />
				</h:commandLink>
			</h:column>
		</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>