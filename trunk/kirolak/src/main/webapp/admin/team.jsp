<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>
		<h:outputFormat value="#{msg.team_title}">
			<f:param value="#{team.parent.name}"/>
			<f:param value="#{team.title}" />
		</h:outputFormat>
	</title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/forms.js"></script>	
	</head>

	<body onload="setFocus('saveTeam:name','${errorField}');">
	<h:form id="saveTeam">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="#{sport.load}" value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="teams_link" action="#{team.load}"	immediate="true">			
			<f:param name="parent" value="#{team.parent.id}"/>
			<h:outputFormat value="#{msg.teams_title}">
				<f:param value="#{team.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputText value="#{team.title}" />
		</div>
		
		<h:inputHidden id="id" value="#{team.item.id}" />

		<h:panelGrid columns="3">

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{team.item.name}" size="25" required="true" >
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{team.item.seoName}" size="25" required="true">
				<f:validateLength minimum="3" maximum="25" />
				<f:validator validatorId="kirolak.seoNameValidator" />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.acronym}" />
			<h:inputText id="acronym" value="#{team.item.acronym}" size="15" required="true">
				<f:validateLength minimum="3" maximum="3" />
			</h:inputText>
			<h:message id="acronymError" for="acronym" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.sport}" />
			<h:selectOneMenu id="teamSport" value="#{team.parent}"
				required="true" converter="kirolak.sportConverter">
				<f:selectItems value="#{sport.selectItems}" />
			</h:selectOneMenu>
			<h:message id="teamSportError" for="teamSport" styleClass="error" />
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{team.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true"/>
	</h:form>
	</body>
	</html>
</f:view>