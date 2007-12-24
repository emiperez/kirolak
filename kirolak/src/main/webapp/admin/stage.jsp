<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
	<html>
	
	<f:view>
	<head>
	<title><h:outputText value="#{stage.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>	
	
	</head>

	<body onload="setFocus('saveStage:name','${errorField}');">
	<h:form id="saveStage">
		<div class="navigation_bar">
		<h:commandLink id="sports_link" action="sports"value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="competitions_link" action="competitions" immediate="true">
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt; 
		<h:commandLink id="stages_link" action="stages" immediate="true">
			<h:outputFormat value="#{msg.stages_title}">
				<f:param value="#{stage.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputText value="#{stage.title}" />
		</div>
		
		<h:inputHidden id="id" value="#{stage.item.id}" />
		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{stage.item.name}" size="25"
				required="true">
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{stage.item.seoName}" size="15"
				required="true">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator validatorId="kirolak.seoNameValidator" />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.start_date}" />
			<h:inputText id="startDate" value="#{stage.item.startDate}" size="12" required="true">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
			<h:message id="startDateError" for="startDate" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.finish_date}" />
			<h:inputText id="finishDate" value="#{stage.item.finishDate}" size="12" required="true">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
			<h:message id="finishDateError" for="finishDate" styleClass="error" />


			<h:outputText styleClass="label" value="#{msg.stage_type}" />
			<h:selectOneMenu id="type" value="#{stage.item.type}"
				required="true">
				<f:selectItems value="#{app.stageTypesSelectItems}" />
			</h:selectOneMenu>
			<h:message id="typeError" for="type" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.matches}" />
			<h:inputText id="matches" value="#{stage.item.matches}" size="2"
				converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="mmatchesError" for="matches" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.play_off_name}" />
			<h:inputText id="playOffName" value="#{stage.item.playOffName}"
				size="25">
			</h:inputText>
			<h:message id="playOffNameError" for="playOffName" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_win}" />
			<h:inputText id="pointsWin" value="#{stage.item.pointsWin}" size="3"
				converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsWinError" for="pointsWin" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_draw}" />
			<h:inputText id="pointsDraw" value="#{stage.item.pointsDraw}"
				size="3" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsDrawError" for="pointsDraw" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.points_loose}" />
			<h:inputText id="pointsLoose" value="#{stage.item.pointsLoose}"
				size="3" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsLooseError" for="pointsLoose" styleClass="error" />

		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{stage.saveItem}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
	</h:form>
	</body>	
	</f:view>
	</html>