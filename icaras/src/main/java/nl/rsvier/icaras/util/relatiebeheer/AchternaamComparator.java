package nl.rsvier.icaras.util.relatiebeheer;

import java.io.Serializable;
import java.util.Comparator;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;

public class AchternaamComparator implements Comparator<Persoon>, Serializable {

	@Override
	public int compare(Persoon p0, Persoon p1) {
		return p0.getAchternaam().compareTo(p1.getAchternaam());
	}

}
