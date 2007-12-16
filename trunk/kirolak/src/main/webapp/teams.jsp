<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<title><h:outputText value="#{sportBean.item.name} - #{msg.teams}" /></title>
	</head>

	<body>
	<h:form id="teams">
	<h:commandLink action="newItem" actionListener="#{teamBean.newItem}" value="#{msg.new}">
		<f:param name="sportId" value="#{sportBean.item.id}" />
	</h:commandLink>
	<h:dataTable value="#{sportBean.teams}" var="item" binding="#{teamBean.itemData}">	
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
			<h:commandLink id="edit" action="#{teamBean.edit}" value="#{msg.edit}" />
		</h:column>
		<h:column>
			<h:commandLink id="delete" action="#{teamBean.delete}" onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
		</h:column>
	</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>