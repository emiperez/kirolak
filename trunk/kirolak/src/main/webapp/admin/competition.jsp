<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>
		<h:outputFormat value="#{msg.competition_title}">
			<f:param value="#{competition.parent.name}"/>
			<f:param value="#{competition.title}" />
		</h:outputFormat>
	</title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/forms.js"></script>	
	</head>

	<body onload="setFocus('saveCompetition:name','${errorField}');">
	<h:form id="saveTeam">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="competitions_link" action="competitions" immediate="true">
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputText value="#{competition.title}" />
		</div>
		
		<h:inputHidden id="id" value="#{competition.item.id}" />

		<h:panelGrid columns="3">

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{competition.item.name}" size="25" required="true">
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{competition.item.seoName}" size="25" required="true">
				<f:validateLength minimum="3" maximum="25" />
				<f:validator validatorId="kirolak.seoNameValidator" />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.start_date}" />
			<h:inputText id="startDate" value="#{competition.item.startDate}" size="12" required="true">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
			<h:message id="startDateError" for="startDate" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.finish_date}" />
			<h:inputText id="finishDate" value="#{competition.item.finishDate}" size="12" required="true">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
			<h:message id="finishDateError" for="finishDate" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.sport}" />
			<h:selectOneMenu id="competitionSport" value="#{competition.parent}"
				required="true" converter="kirolak.sportConverter">
				<f:selectItems value="#{sport.selectItems}" />
			</h:selectOneMenu>
			<h:message id="competitionSportError" for="competitionSport" styleClass="error" />
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{competition.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true"/>
	</h:form>
	</body>
	</html>
</f:view>