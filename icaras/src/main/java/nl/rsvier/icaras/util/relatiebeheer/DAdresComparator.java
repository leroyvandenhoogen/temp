package nl.rsvier.icaras.util.relatiebeheer;

import java.io.Serializable;
import java.util.Comparator;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;

public class DAdresComparator implements Comparator<DigitaalAdres>,
		Serializable {

	@Override
	public int compare(DigitaalAdres o1, DigitaalAdres o2) {
		if (o1.isContactvoorkeur() && !o2.isContactvoorkeur())
			return 1;
		else if (!o1.isContactvoorkeur() && o2.isContactvoorkeur())
			return -1;
		return 0;
	}

}
