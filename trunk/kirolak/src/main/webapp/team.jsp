<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<title>
		<h:outputFormat value="#{msg.team_title}">
			<f:param value="#{team.parent.name}"/>
			<f:param value="#{team.title}" />
		</h:outputFormat>
	</title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body bgcolor="white">
	<h:form id="saveTeam">
		<div class="navigation_bar">
		<h:outputLink id="sports_url"
			value="#{facesContext.externalContext.requestContextPath}">
			<h:outputText value="#{msg.sports}" />
		</h:outputLink> 
		&gt; 
		<h:commandLink id="teams_url" action="list">
			<h:outputFormat value="#{msg.teams_title}">
				<f:param value="#{team.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputFormat value="#{msg.team_title}">
			<f:param value="#{team.parent.name}"/>
			<f:param value="#{team.title}" />
		</h:outputFormat>
		</div>
		
		<h:inputHidden id="id" value="#{team.item.id}" />

		<h:panelGrid columns="3">

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{team.item.name}" size="25">
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{team.item.seoName}" size="15">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator validatorId="kirolak.seoNameValidator" />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.acronym}" />
			<h:inputText id="acronym" value="#{team.item.acronym}" size="15">
				<f:validateLength minimum="3" maximum="3" />
			</h:inputText>
			<h:message id="acronymError" for="acronym" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.sport}" />
			<h:selectOneMenu id="teamSport" value="#{team.item.sport}"
				required="true" converter="kirolak.sportConverter">
				<f:selectItems value="#{sport.selectItems}" />
			</h:selectOneMenu>
			<h:message id="teamSportError" for="teamSport" styleClass="error" />
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{team.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" />
	</h:form>
	</body>
	</html>
</f:view>