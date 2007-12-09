<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:loadBundle basename="com.kirolak.bundle.messages" var="msg" />
<f:view>
	<html>
	<head>
	<title><h:outputText value="#{sport.name}" /></title>
	</head>

	<body bgcolor="white">
	<h:form id="saveSport">
		<h:inputHidden id="id" value="#{sport.id}" />
		<h:panelGrid columns="2">
		<f:facet name="header">
    		<h:outputText value="#{msg.sport}"/>
  		</f:facet>
		
		<h:outputText value="#{msg.seo_name}" />
		<h:inputText id="seo" value="#{sport.seoName}" />
		
		<h:outputText value="#{msg.name}" />
		<h:inputText id="name" value="#{sport.name}" />
		
		</h:panelGrid>
		<h:commandButton value="#{msg.save}" action="#{sport.save}" />
	</h:form>
	</body>
	</html>
</f:view>