package br.edu.unibratec.psc.web.jsf;

import java.util.regex.Pattern;

import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class AuthPhaseListener implements PhaseListener {
	
	private static final String RESTRICTION_PATTERNS = "ˆ/restricted/.*";
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		String viewId = context.getViewRoot().getViewId();
		
		boolean urlProtected =
			Pattern.matches(RESTRICTION_PATTERNS, viewId);
		
		Object user = context.getExternalContext().getSessionMap().get("loggedUser");
		
		if ( urlProtected && user == null ) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			
			navigator.handleNavigation(context, null, "login");
		}
	}
	
}