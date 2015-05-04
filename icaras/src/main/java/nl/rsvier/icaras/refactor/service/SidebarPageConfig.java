package nl.rsvier.icaras.refactor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import nl.rsvier.icaras.refactor.core.SidebarPage;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("sidebarPageConfig")
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SidebarPageConfig {
	
	HashMap<String, SidebarPage> pageMap = new LinkedHashMap<String, SidebarPage>();
	
	public SidebarPageConfig(){
		
		pageMap.put("RSvier", new SidebarPage("RSvier home", "/resources/rs4/images/rsv32.png", "http://www.rsvier.nl"));
		pageMap.put("ICARAS", new SidebarPage("ICARAS home", "/resources/rs4/images/icons/simpleicons/home.png", "http://localhost:8181/Icaras"));
		
		pageMap.put("Persoonlijst", new SidebarPage("Persoonlijst", "/resources/rs4/images/icons/simpleicons/user.png", "/index-persoonlijst.zul"));
		pageMap.put("Organisatielijst", new SidebarPage("Organisatielijst", "/resources/rs4/images/icons/simpleicons/company.png", "/index-organisatielijst.zul"));		
	}
	
	public List<SidebarPage> getPages() {
		return new ArrayList<SidebarPage>(pageMap.values());
	}
	
	public SidebarPage getPage(String name) {
		return pageMap.get(name);
	}
}
