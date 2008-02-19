<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>

<f:view>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><h:outputText value="#{round.title}" /></title>
	<link href="css/forms.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/forms.js"></script>

	</head>

	<body onload="setFocus('saveRound:name','${errorField}');">
	<h:form id="saveRound">
		<div class="navigation_bar"><h:commandLink id="sports_link" action="#{sport.load}" value="#{msg.sports}" immediate="true" />
		&gt; 
		<h:commandLink id="competitions_link" action="#{competition.load}"	immediate="true">			
			<f:param name="parent" value="#{competition.parent.id}"/>
			<h:outputFormat value="#{msg.competitions_title}">
				<f:param value="#{competition.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;  
		<h:commandLink id="stages_link" action="#{stage.load}"	immediate="true">			
			<f:param name="parent" value="#{stage.parent.id}"/>
			<h:outputFormat value="#{msg.stages_title}">
				<f:param value="#{stage.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;  
		<h:commandLink id="groups_link" action="#{group.load}"	immediate="true">			
			<f:param name="parent" value="#{group.parent.id}"/>
			<h:outputFormat value="#{msg.groups_title}">
				<f:param value="#{group.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;  
		<h:commandLink id="rounds_link" action="#{round.load}"	immediate="true">			
			<f:param name="parent" value="#{round.parent.id}"/>
			<h:outputFormat value="#{msg.rounds_title}">
				<f:param value="#{round.parent.name}" />
			</h:outputFormat>
		</h:commandLink>
		&gt;
		<h:outputText value="#{round.title}" />
		</div>
		<!-- END OF NAVIGATION_BAR -->

		<h:panelGrid columns="3">
			<h:outputText styleClass="label" value="#{msg.round}" />
			<h:inputText id="id" value="#{round.item.compositeId.id}" size="3"
				required="true">
			</h:inputText>
			<h:message id="idError" for="id" styleClass="error" />

			<h:outputText styleClass="label" value="#{msg.date}" />
			<h:inputText id="day" value="#{round.item.day}" size="12"
				required="true">
				<f:convertDateTime dateStyle="short" />
			</h:inputText>
			<h:message id="dayError" for="day" styleClass="error" />

		</h:panelGrid>

		<h:dataTable value="#{round.listMatch}" var="item">
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.day_time}" />
				</f:facet>
				<h:inputText id="dayTime" value="#{item.dayTime}">
					<f:convertDateTime dateStyle="short" timeStyle="short" />
				</h:inputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.home_team}" />
				</f:facet>
				<h:selectOneMenu id="homeTeam" value="#{item.homeTeam}"
					converter="kirolak.teamConverter">
					<f:selectItems value="#{round.selectableTeams}" />
				</h:selectOneMenu>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.score}" />
				</f:facet>
				<h:inputText id="homeTeamScore" value="#{item.homeTeamScore}" size="5"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.visiting_team}" />
				</f:facet>
				<h:selectOneMenu id="visitingTeam" value="#{item.visitingTeam}"
					converter="kirolak.teamConverter">
					<f:selectItems value="#{round.selectableTeams}" />
				</h:selectOneMenu>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.score}" />
				</f:facet>
				<h:inputText id="visitingTeamScore" value="#{item.visitingTeamScore}" size="5"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.status}" />
				</f:facet>
				<h:selectOneMenu id="mode" value="#{item.matchStatus}" required="true">
					<f:selectItems value="#{app.matchStatusSelectItems}" />
				</h:selectOneMenu>
			</h:column>
		</h:dataTable>		
		<h:messages />
		<h:commandButton value="#{msg.save}" action="#{round.saveRound}" />
		<h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
		
		<h:dataTable value="#{round.standings}" var="item" rowClasses="row">
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.team}" />
				</f:facet>
				<h:outputText id="team" value="#{item.id.team.name}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.games_abbr}" />
				</f:facet>
				<h:outputText id="games" value="#{item.games}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.won_abbr}" />
				</f:facet>
				<h:outputText id="won" value="#{item.wonGames}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.drawn_abbr}" />
				</f:facet>
				<h:outputText id="drawn" value="#{item.drawnGames}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.lost_abbr}" />
				</f:facet>
				<h:outputText id="lost" value="#{item.lostGames}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.scored_abbr}" />
				</f:facet>
				<h:outputText id="scored" value="#{item.scoreTotal}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.received_abbr}" />
				</f:facet>
				<h:outputText id="scoredAgainst" value="#{item.scoreAgainstTotal}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msg.points_abbr}" />
				</f:facet>
				<h:outputText id="points" value="#{item.teamPoints}" />
			</h:column>
			
		</h:dataTable>
		
	</h:form>
	</body>
</f:view>
</html>