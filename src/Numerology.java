
public class Numerology {

	private int month;
	private int day;
	private int year;
	private int result;
	private String prediction;
	
	public Numerology() {
		this.setMonth(0);
		this.setDay(0);
		this.setYear(0);
		this.setResult(0);
		this.setPrediction(null);
	}
	
	
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	
	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
	
	/**
	 * @return the prediction
	 */
	public String getPrediction() {
		return prediction;
	}
	
	/**
	 * @param prediction the prediction to set
	 */
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	
	/**
	 * @return the whole numerology
	 */
	public String getNumerology() {
		String numObject = "Date: " + getDate() + "\t" + "Prediction: " + getPrediction();
		return numObject;
	}
	
	/**
	 * @returns the date of numerology
	 */
	public String getDate() {
		String month = String.valueOf(getMonth());
		String day = String.valueOf(getDay());
		
		if(month.length() == 1)
			month = "0" + month;
		
		if(day.length() == 1)
			day = "0"+ day;
			
		String date = month + "/" + day + "/" + getYear();
		return date;
	}
	
	
}
