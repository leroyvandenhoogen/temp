package nl.rsvier.icaras.refactor.controller;

import nl.rsvier.icaras.refactor.core.SidebarPage;
import nl.rsvier.icaras.refactor.service.SidebarPageConfig;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Toolbarbutton;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SidebarController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	//wire components
	@Wire
	Grid sidebarList;
	
	//services
	SidebarPageConfig pageConfig = new SidebarPageConfig();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		//initialize rows of the sidebar Grid after view construction
		Rows rows = sidebarList.getRows();
		
		for(SidebarPage page:pageConfig.getPages()) {
			Row row = constructSidebarRow(page.getLabel(), page.getIconUri(), page.getUri());
			rows.appendChild(row);
		}
	}
	
	private Row constructSidebarRow(String label, String imageSrc, final String locationUri) {
		
		//construct component and hierarchy
		Row row = new Row();
		Image image = new Image(imageSrc);
		Toolbarbutton toolbarbutton = new Toolbarbutton(label);
		toolbarbutton.setHref(locationUri);
		
		row.appendChild(image);
		row.appendChild(toolbarbutton);
		
		//set style attribute
		row.setSclass("sidebar");
		
		/*
		//create and register event listener
		EventListener<Event> actionListener = new SerializableEventListener<Event>() {
			private static final long serialVersionUID = 1L;
			
			public void onEvent(Event event) throws Exception {
				//redirect current url to new location
				Executions.getCurrent().sendRedirect(locationUri);
			}
		};
		row.addEventListener(Events.ON_CHECK, actionListener);
		*/
		return row;
	}
}
