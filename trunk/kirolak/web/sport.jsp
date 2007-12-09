<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:loadBundle basename="com.kirolak.bundle.messages" var="msg" />
<f:view>
	<html>
	<head>
	<title><h:outputText value="#{sport.name}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css">
	</head>

	<body bgcolor="white">
	<h:form id="saveSport">
		<h:inputHidden id="id" value="#{sport.id}" />
		<h:panelGrid columns="3" >
			<f:facet name="header">
				<h:outputText value="#{msg.sport}" />
			</f:facet>

			<h:outputText value="#{msg.seo_name}" />
			<h:inputText id="seo" value="#{sport.seoName}" size="15">
				<f:validateLength minimum="2" maximum="15" />
				<f:validator  validatorId="kirolak.seoNameValidator"  />
			</h:inputText>
			<h:message id="seoNameError" for="seo" styleClass="error" />

			<h:outputText value="#{msg.name}" />
			<h:inputText id="name" value="#{sport.name}" size="15">				
				<f:validateLength minimum="3" maximum="25" />
			</h:inputText>
			<h:message id="nameError" for="name" styleClass="error" />

		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{sport.save}" />
	</h:form>
	</body>
	</html>
</f:view>