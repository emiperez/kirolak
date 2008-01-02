<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputFormat value="#{msg.stages_title}">
		<f:param value="#{stage.parent.name}" />
	</h:outputFormat></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<h:form id="stages">

		<div class="navigation_bar">
			<h:commandLink id="sports_link" action="#{sport.load}" value="#{msg.sports}" immediate="true" />
		&gt; <h:commandLink id="competitions_link" action="#{competition.load}"	immediate="true">			
					<f:param name="parent" value="#{competition.parent.id}"/>
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink> &gt; <h:outputFormat value="#{msg.stages_title}">
			<f:param value="#{stage.parent.name}" />
		</h:outputFormat></div>

		<h:commandButton action="#{stage.newItem}" value="#{msg.new}" />
		<h:dataTable value="#{stage.items}" var="item"
			binding="#{stage.itemData}" rowClasses="row">
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
					<f:convertDateTime dateStyle="long" />
				</h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.finish_date}" />
				</f:facet>
				<h:outputText value="#{item.finishDate}">
					<f:convertDateTime dateStyle="long" />
				</h:outputText>
			</h:column>
			<h:column>
				<h:commandButton id="edit" action="#{stage.editItem}"
					value="#{msg.edit}" />
			</h:column>
			<h:column>
				<h:commandButton id="delete" action="#{stage.deleteItem}"
					onclick="return confirm('#{msg.sure}')" value="#{msg.delete}" />
			</h:column>
			<h:column>
				<h:commandLink id="groups" action="#{group.load}">
					<f:param name="parent" value="#{item.id}" />
					<h:outputText value="#{msg.groups}" />
				</h:commandLink>
			</h:column>
		</h:dataTable>
	</h:form>
	</body>
	</html>
</f:view>