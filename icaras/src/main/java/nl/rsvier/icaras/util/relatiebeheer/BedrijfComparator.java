package nl.rsvier.icaras.util.relatiebeheer;

import java.io.Serializable;
import java.util.Comparator;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public class BedrijfComparator implements Comparator<Bedrijf>, Serializable {

	@Override
	public int compare(Bedrijf o1, Bedrijf o2) {
		if (o1.getNaam().compareTo(o2.getNaam()) == 0) {
			Adres adres1 = new Adres();
			Adres adres2 = new Adres();
			for (Adres adres : o1.getAdressen()) {
				if (adres.getAdresType().getType().equals("bezoek")) {
					adres1 = adres;
				}
			}
			for (Adres adres : o2.getAdressen()) {
				if (adres.getAdresType().getType().equals("bezoek")) {
					adres2 = adres;
				}
			}
			if (adres1 != null && adres2 != null)
				return adres1.getPlaats().compareTo(adres2.getPlaats());
			else
				return 0;
		} else
			return o1.getNaam().compareTo(o2.getNaam());

	}

}
