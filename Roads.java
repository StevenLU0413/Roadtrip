public class Roads{
	
	private String currentCity;
	private String nextCity;
	private String distance;
	private String time;
	private int index;//add index so it is easier to keeping track of
	
	public Roads(){
		
	}
	
	public Roads(String aCurrentCity, String aNextCity, String aDistance, String aTime, int aIndex){
		currentCity = aCurrentCity;
		nextCity = aNextCity;
		distance = aDistance;
		time = aTime;
		index = aIndex;
	}
	
	
	public String getCurrentCity(){
		return currentCity;
	}
	
	public String getNextCity(){
		return nextCity;
	}
	
	public String getDistance(){
		return distance;
	}
	
	public String getTime(){
		return time;
	}
	
	public int getIndex(){
		return index;
	}
	
	
	
}