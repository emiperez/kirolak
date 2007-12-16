<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<html>
	<head>
	<title><h:outputText value="#{teamBean.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body bgcolor="white">
	<h:outputText styleClass="title" value="#{teamBean.title}" />
	<h:form id="saveTeam">
		<h:inputHidden id="id" value="#{teamBean.item.id}" />
		
		<h:panelGrid columns="3" >

			<h:outputText styleClass="label" value="#{msg.name}" />
			<h:inputText id="name" value="#{teamBean.item.name}" size="25">				
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{teamBean.item.seoName}" size="15">
				<f:validateLength minimum="3" maximum="15" />
				<f:validator  validatorId="kirolak.seoNameValidator"  />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />
			
			<h:outputText styleClass="label" value="#{msg.acronym}" />
			<h:inputText id="acronym" value="#{teamBean.item.acronym}" size="3">				
				<f:validateLength minimum="3" maximum="3" />
			</h:inputText>
			<h:message id="acronymError" for="acronym" styleClass="error" />

			
			<h:outputText styleClass="label" value="#{msg.sport}" />
			<h:selectOneMenu id="sport" value="#{teamBean.item.sport}" required="true">
				<f:selectItems value="#{app.sportsSelectItems}" />
			</h:selectOneMenu>
			<h:message id="sportError" for="sport" styleClass="error" />
			
			
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{teamBean.item.save}" />
	</h:form>
	</body>
	</html>
</f:view>