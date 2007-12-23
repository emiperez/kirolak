/*
 * Obtained from:
 * http://balusc.blogspot.com/2007/12/set-focus-in-jsf.html
 */

package com.kirolak.jsf.listeners;

import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ErrorFieldListener implements PhaseListener
{

	// Actions
	// ------------------------------------------------------------------------------------

	public PhaseId getPhaseId()
	{

		// Listen on render response phase.
		return PhaseId.RENDER_RESPONSE;
	}

	public void beforePhase(PhaseEvent event)
	{

		// Init.
		FacesContext facesContext = event.getFacesContext();

		// Get an iterator over all client ID's with messages.
		Iterator<String> clientIdsWithMessages = facesContext.getClientIdsWithMessages();

		// If there is a client ID with message ..
		if (clientIdsWithMessages.hasNext())
		{
			// .. obtain the first client ID with message.
			String firstClientIdWithMessage = clientIdsWithMessages.next();

			// Set the focus to this client ID. The value will be available in
			// ${ErrorFieldListener.errorField} in JSP.
			facesContext.getExternalContext().getRequestMap().put("errorField", firstClientIdWithMessage);
		}
	}

	public void afterPhase(PhaseEvent event)
	{
		// Do nothing.
	}

}