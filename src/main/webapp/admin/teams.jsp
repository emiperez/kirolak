<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view >
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>
		<h:outputFormat value="#{msg.teams_title}">
			<f:param value="#{team.parent.name}"/>
		</h:outputFormat>
	</title>	
	<link href="css/forms.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
	<h:form id="teams">
	
	<div class="navigation_bar">
		<h:commandLink id="sports_link" action="#{sport.load}"value="#{msg.sports}" immediate="true" /> 
		&gt; 
		<h:outputFormat value="#{msg.teams_title}">
			<f:param value="#{team.parent.name}"/>
		</h:outputFormat>
	</div>
	
	<h:commandButton action="#{team.newItem}" value="#{msg.new}"/>
	<h:dataTable value="#{team.items}" var="item"
			binding="#{team.itemData}" rowClasses="row">	
		<h:column>
			<f:facet name="header">
				<h:outputText value="#{msg.acronym}" />
			</f:facet>
			<h:outputText value="#{item.acronym}" />
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
			<h:commandButton id="edit" action="#{team.editItem}" value="#{msg.edit}" />
		</h:column>
		<h:column>
			<h:commandButton id="delete" action="#{team.deleteItem}" onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
		</h:column>
	</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>