package nl.rsvier.icaras.refactor.core;

import java.io.Serializable;

public class SidebarPage implements Serializable{

	private static final long serialVersionUID = 1L;
	String label;
	String iconUri;
	String uri;
	
	public SidebarPage(String label, String iconUri, String uri) {
		this.label = label;
		this.iconUri = iconUri;
		this.uri = uri;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIconUri() {
		return iconUri;
	}

	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
