public class Attractions{
	Roadtrip roadtripObject = new Roadtrip();	
	private String name;
	private String location;
	private int index;//add index so it is easier to keep track of
	
	public Attractions(){
		
	}
	
	public Attractions(String aName, String aLocation, int aIndex){
		name = aName;
		location = aLocation;
		index = aIndex;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
	
	public int getIndex(){
		return index;
	}
	
	
}