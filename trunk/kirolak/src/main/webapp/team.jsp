<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<title><h:outputText value="#{team.parent.name}: #{team.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body bgcolor="white">
	<h:outputText styleClass="title" value="#{team.parent.name}: #{team.title}" />
	<h:form id="saveTeam">
		<h:inputHidden id="id" value="#{team.item.id}" />
		
		<h:panelGrid columns="3" >

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{team.item.name}" size="25">				
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{team.item.seoName}" size="15">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator  validatorId="kirolak.seoNameValidator"  />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.acronym}" />
			<h:inputText id="acronym" value="#{team.item.acronym}" size="15">
				<f:validateLength minimum="3" maximum="3" />
			</h:inputText>
			<h:message id="acronymError" for="acronym" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.sport}" />
			<h:selectOneMenu id="teamSport" value="#{team.item.sport}" required="true" converter="kirolak.sportConverter">
				<f:selectItems value="#{sport.selectItems}" />
			</h:selectOneMenu>
			<h:message id="teamSportError" for="teamSport" styleClass="error" />
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{team.saveItem}" />
	</h:form>
	</body>
	</html>
</f:view>