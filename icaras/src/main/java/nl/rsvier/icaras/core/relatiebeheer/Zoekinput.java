package nl.rsvier.icaras.core.relatiebeheer;

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
		double totalSeconds = (double)((stop - start) / 1000000000);
		String totalRounded = new BigDecimal(String.valueOf(totalSeconds)).setScale(5, BigDecimal.ROUND_HALF_EVEN).toString();
		this.total = totalRounded;
	}
	
	public String getTotal() {
		return total;
	}
}	
