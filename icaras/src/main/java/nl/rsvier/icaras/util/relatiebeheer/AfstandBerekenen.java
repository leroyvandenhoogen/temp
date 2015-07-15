package nl.rsvier.icaras.util.relatiebeheer;

public class AfstandBerekenen {

	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;

	public int calculateDistance(double latA, double lonA, double latB,
			double lonB) {

		double latDistance = Math.toRadians(latA - latB);
		double lngDistance = Math.toRadians(lonA - lonB);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(latA))
				* Math.cos(Math.toRadians(latB)) * Math.sin(lngDistance / 2)
				* Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));
	}

}
