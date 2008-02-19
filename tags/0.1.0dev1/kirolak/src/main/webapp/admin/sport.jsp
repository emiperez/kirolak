<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
	<html>
	
	<f:view>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><h:outputText value="#{sport.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>	
	
	</head>

	<body onload="setFocus('saveSport:name','${errorField}');">
	<h:form id="saveSport">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports" value="#{msg.sports}" immediate="true" /> &gt; <h:outputText value="#{sport.title}" /></div>
		<h:inputHidden id="id" value="#{sport.item.id}" />
		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{sport.item.name}" size="25"
				required="true">
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{sport.item.seoName}" size="15"
				required="true">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator validatorId="kirolak.seoNameValidator" />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />


			<h:outputText styleClass="label" value="#{msg.score_mode}" />
			<h:selectOneMenu id="mode" value="#{sport.item.scoreMode}"
				required="true">
				<f:selectItems value="#{app.scoreModesSelectItems}" />
			</h:selectOneMenu>
			<h:message id="scoreModeError" for="mode" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.part_name}" />
			<h:inputText id="part" value="#{sport.item.partName}" size="25">
			</h:inputText>
			<h:message id="partNameError" for="part" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.max_parts}" />
			<h:inputText id="maxParts" value="#{sport.item.maxParts}" size="2"
				converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="maxPartsError" for="maxParts" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.play_off_name}" />
			<h:inputText id="playOffName" value="#{sport.item.playOffName}"
				size="25">
			</h:inputText>
			<h:message id="playOffNameError" for="playOffName" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_win}" />
			<h:inputText id="pointsWin" value="#{sport.item.pointsWin}" size="3"
				converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsWinError" for="pointsWin" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_draw}" />
			<h:inputText id="pointsDraw" value="#{sport.item.pointsDraw}"
				size="3" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsDrawError" for="pointsDraw" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_loose}" />
			<h:inputText id="pointsLoose" value="#{sport.item.pointsLoose}"
				size="3" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsLooseError" for="pointsLoose" styleClass="error" />

		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{sport.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
	</h:form>
	</body>	
	</f:view>
	</html>