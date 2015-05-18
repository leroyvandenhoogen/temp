package nl.rsvier.icaras.refactor.controller;

import java.util.Iterator;
import java.util.List;

import nl.rsvier.icaras.refactor.core.Nfa;
import nl.rsvier.icaras.refactor.core.Persoon;
import nl.rsvier.icaras.refactor.core.PersoonsRol;
import nl.rsvier.icaras.refactor.service.OrganisatieService;
import nl.rsvier.icaras.refactor.service.PersoonService;
import nl.rsvier.icaras.refactor.service.RelatieService;

import org.springframework.test.context.ContextConfiguration;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

@ContextConfiguration(locations = {"classpath:icarastestdb-context.xml"})
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PersoonlijstController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	//wire components
	@Wire
	private Listbox persoonListbox;
	@Wire
	private Component selectedPersoonBlock;
	@Wire
	private Listbox persoonsRolListbox;
	
	@Wire
	private Textbox selectedPersoonVoornaam;
	@Wire
	private Textbox selectedPersoonTussenvoegsels;
	@Wire
	private Textbox selectedPersoonAchternaam;
	@Wire
	private Datebox selectedPersoonGeboortedatum;
	@Wire
	private Textbox selectedPersoonStraat;
	@Wire
	private Textbox selectedPersoonStraatNummer;
	@Wire
	private Textbox selectedPersoonPostcode;
	@Wire
	private Textbox selectedPersoonPlaats;
	@Wire
	private Textbox selectedPersoonOpmerking;
	@Wire
	private Textbox selectedPersoonTelefoonNummer;
	@Wire
	private Textbox selectedPersoonEmail;
	
	//services
	@WireVariable
	private PersoonService persoonService;
	@WireVariable
	private RelatieService relatieService;
	@WireVariable
	private OrganisatieService organisatieService;
	
	//data for the view
	ListModelList<Persoon> persoonListModel;
	Persoon selectedPersoon;
	ListModelList<PersoonsRol> persoonsRolListModel;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		persoonService = (PersoonService)SpringUtil.getBean("IPersoonService");
		//get data from service and wrap it to the listmodel for the view
		List<Persoon> persoonList = persoonService.getAllCompleet();
		persoonListModel = new ListModelList<Persoon>(persoonList);
		persoonListbox.setModel(persoonListModel);
		
		
	}
	
	//Wordt aangeroepen als gebruiker een persoon selecteert
	@Listen("onSelect = #persoonListbox")
	public void persoonSelect() {
		selectedPersoon = null;
		
		if(!(persoonListModel.isSelectionEmpty())) { 
			selectedPersoon = persoonListModel.getSelection().iterator().next();
		}
		
		refreshDetailView();
	}

	private void refreshDetailView() {
		//refresh de detail view van een geselecteerd persoon
		if(selectedPersoon == null){
			selectedPersoonBlock.setVisible(false);
			selectedPersoonVoornaam.setValue(null);
			selectedPersoonTussenvoegsels.setValue(null);
			selectedPersoonAchternaam.setValue(null);
			selectedPersoonGeboortedatum.setValue(null);
			selectedPersoonStraat.setValue(null);
			selectedPersoonStraatNummer.setValue(null);
			selectedPersoonPostcode.setValue(null);
			selectedPersoonPlaats.setValue(null);
			selectedPersoonTelefoonNummer.setValue(null);
			selectedPersoonEmail.setValue(null);
			
			selectedPersoonOpmerking.setValue(null);
			
			persoonsRolListModel = null;
			persoonsRolListbox = null;
		}else{
			//Naam
			selectedPersoonBlock.setVisible(true);			
			selectedPersoonVoornaam.setValue(selectedPersoon.getVoornaam());
			selectedPersoonTussenvoegsels.setValue(selectedPersoon.getTussenvoegsels());
			selectedPersoonAchternaam.setValue(selectedPersoon.getAchternaam());
			
			//Geboortedatum
			if(selectedPersoon.getGeboortedatum() != null) { 
			selectedPersoonGeboortedatum.setValue(selectedPersoon.getGeboortedatum().getTime());
			}else{
				selectedPersoonGeboortedatum.setValue(null);
			}
			
			//Adresgegevens
			if(selectedPersoon.getCorrespondentieAdres() != null) { 
			selectedPersoonStraat.setValue(selectedPersoon.getCorrespondentieAdres().getStraat());
			selectedPersoonStraatNummer.setValue(selectedPersoon.getCorrespondentieAdres().getHuisOfPostbusNummer());
			selectedPersoonPostcode.setValue(selectedPersoon.getCorrespondentieAdres().getPostcode());
			selectedPersoonPlaats.setValue(selectedPersoon.getCorrespondentieAdres().getPlaats());
			}else{
				selectedPersoonStraat.setValue(null);
				selectedPersoonStraatNummer.setValue(null);
				selectedPersoonPostcode.setValue(null);
				selectedPersoonPlaats.setValue(null);
			}
			
			//Opmerking
			selectedPersoonOpmerking.setValue(selectedPersoon.getOpmerking());
			
			//Niet fysieke adressen
			selectedPersoonEmail.setValue(null);
			selectedPersoonTelefoonNummer.setValue(null);
			Iterator<Nfa> nfaLijstIterator = selectedPersoon.getNfaLijst().iterator();
			while(nfaLijstIterator.hasNext()) {
				Nfa tempnfa = nfaLijstIterator.next();
				switch (tempnfa.getNfaSoort()) {
				case EMAIL:
					selectedPersoonEmail.setValue(tempnfa.getNfaAdres());
					break;
				case FACEBOOK:
					break;
				case FAX:
					break;
				case LINKEDIN:
					break;
				case TELEFOONNUMMER:
					selectedPersoonTelefoonNummer.setValue(tempnfa.getNfaAdres());
					break;
				case TWITTER:
					break;
				case WEBSITE:
					break;
				default:
					break;
				}
			}
			
			//Persoonsrollen
			if(!(selectedPersoon.getRollen().isEmpty())) { 
				persoonsRolListModel = new ListModelList<PersoonsRol>(selectedPersoon.getRollen());
				
			}else{
				persoonsRolListModel = null;
			}
			persoonsRolListbox.setModel(persoonsRolListModel);
			
		}	
	}
}
