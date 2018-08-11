package br.com.alura.lib.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.alura.lib.jsf.annotation.ScopeMap;
import br.com.alura.lib.jsf.annotation.ScopeMap.Scope;

public class JSFFactory {
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public Flash getFlash() {
		return getFacesContext().getExternalContext().getFlash();
	}
	
	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> requestMap() {
		return getFacesContext().getExternalContext().getRequestMap();
	}
	
	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> sessionMap() {
	    return getFacesContext().getExternalContext().getSessionMap();
	}
	
	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> applicationMap() {
	    return getFacesContext().getExternalContext().getApplicationMap();
	}

}
