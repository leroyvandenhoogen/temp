package nl.rsvier.icaras.util.relatiebeheer;

import java.math.BigDecimal;

public class Zoekinput {
	private String input;
	private long start;
	private long stop;
	private String total;
	
	public Zoekinput() {
	}
	
	public Zoekinput(String input) {
		this.input = input;
	}
	
	public String getInput(){
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public void startTimer() {
		this.start = System.nanoTime();
	}
	
	public void stopTimer() {
		this.stop = System.nanoTime();
		double totalTemp = (double)((stop - start));
		String totalRounded = new BigDecimal(String.valueOf(totalTemp  / 1000000000)).setScale(3, BigDecimal.ROUND_HALF_EVEN).toString();
		this.total = totalRounded;
	}
	
	public String getTotal() {
		return total;
	}
}	
