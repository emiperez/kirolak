<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<title><h:outputText value="#{sportBean.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body bgcolor="white">
	<h:outputText styleClass="title" value="#{sportBean.title}" />
	<h:form id="saveSport">
		<h:inputHidden id="id" value="#{sportBean.item.id}" />
		
		<h:panelGrid columns="3" >

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{sportBean.item.name}" size="25">				
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{sportBean.item.seoName}" size="15">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator  validatorId="kirolak.seoNameValidator"  />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />

			
			<h:outputText styleClass="label" value="#{msg.score_mode}" />
			<h:selectOneMenu id="mode" value="#{sportBean.item.scoreMode}" required="true">
				<f:selectItems value="#{app.scoreModesSelectItems}" />
			</h:selectOneMenu>
			<h:message id="scoreModeError" for="mode" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.part_name}" />
			<h:inputText id="part" value="#{sportBean.item.partName}" size="25">
			</h:inputText>
			<h:message id="partNameError" for="part" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.max_parts}" />
			<h:inputText id="maxParts" value="#{sportBean.item.maxParts}" size="2" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="maxPartsError" for="maxParts" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.play_off_name}" />
			<h:inputText id="playOffName" value="#{sportBean.item.playOffName}" size="25">
			</h:inputText>
			<h:message id="playOffNameError" for="playOffName" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.points_win}" />
			<h:inputText id="pointsWin" value="#{sportBean.item.pointsWin}" size="3" converter="javax.faces.Byte">
			</h:inputText>
			<h:message id="pointsWinError" for="pointsWin" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.points_draw}" />
			<h:inputText id="pointsDraw" value="#{sportBean.item.pointsDraw}" size="3" converter="javax.faces.Byte">	
			</h:inputText>
			<h:message id="pointsDrawError" for="pointsDraw" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.points_loose}" />
			<h:inputText id="pointsLoose" value="#{sportBean.item.pointsLoose}" size="3" converter="javax.faces.Byte">		
			</h:inputText>
			<h:message id="pointsLooseError" for="pointsLoose" styleClass="error" />
			
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{sportBean.saveItem}" />
	</h:form>
	</body>
	</html>
</f:view>