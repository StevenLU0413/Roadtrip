import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;

public class Roadtrip{
	
	
	ArrayList<Roads> roadList = new ArrayList<Roads>();
	ArrayList<Attractions> attractionList = new ArrayList<Attractions>();
	ArrayList<Roads> visitRoute = new ArrayList<Roads>();

	public ArrayList<Roads> roadsInfo(File roads) throws IOException{//read in the roads file and store it 
		BufferedReader roadReader = new BufferedReader(new FileReader(roads));
		ArrayList<Roads> addroad = new ArrayList<Roads>();	
		String currline;
		int index = 0;
		String currentcity = "";
		while ((currline = roadReader.readLine()) != null) {
			String[] info = currline.split(",");//split in to 4 pieces of information, city name, next city name, distance, time
			Roads c = new Roads(info[0], info[1], info[2], info[3], index);
			System.out.println(index + ": " + info[0]);
			roadList.add(c);
			index++;
		}
		
		return roadList;
	}
	
	
	public ArrayList<Attractions> attractionsInfo(File attractions) throws IOException{
		BufferedReader attractionReader = new BufferedReader(new FileReader(attractions));
		ArrayList<Attractions> addevent = new ArrayList<Attractions>();
		
		String currline;
		int index = 0;
		String currentattraction = "";
		String junkline = attractionReader.readLine();
		while ((currline = attractionReader.readLine()) != null) {
			String[] linecontent = currline.split(","); 
			Attractions a = new Attractions(linecontent[0], linecontent[1], index);
			attractionList.add(a);
			
			if (linecontent[0].equals(currentattraction) == false) {
				currentattraction = linecontent[0];
				System.out.println(index + ": " + linecontent[0]+", "+linecontent[1]);
				index++;
			}
		}
		return attractionList;
	}
	
	public ArrayList<Roads> route(int starting_city, int ending_city, ArrayList<Integer> attractions){
		
		Roads start = roadList.get(starting_city);
		Roads end = roadList.get(ending_city);
		Roads c;
		
		visitRoute.add(start);
		
		for(int i = 0; i < attractions.size(); i++){
			String currentCity = attractionList.get(attractions.get(i)).getLocation();
			Roads city = null;
			int count = 0;
			while (city == null)
			{
				if (currentCity.equals(roadList.get(count).getCurrentCity()) || currentCity.equals(roadList.get(count).getNextCity()) && count != 521)  
				{
					if (currentCity.equals(roadList.get(count).getCurrentCity())) {
						city = roadList.get(count);
					}
					else if (currentCity.equals(roadList.get(count).getNextCity())) {
						c = new Roads(currentCity, null, null, null, 0);
						visitRoute.add(c);
						city = roadList.get(count);
					}
				}
				count++;
			}
			visitRoute.add(city);
			
		
		visitRoute.add(end);
		}
		for (int i = 0; i < visitRoute.size(); i++) {
			System.out.println(visitRoute.get(i).getCurrentCity());
		}
			return visitRoute;
	}
	
	
	public static void main (String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		Roads roadObject = new Roads();
		
		File attractions = new File("attractions.csv");
		File roads = new File("roads.csv");
		Roadtrip trip = new Roadtrip(); 
		
		int city_count = trip.roadsInfo(roads).size();
		int startCity = -1;
		int endCity = -1;
		while (startCity < 0 || startCity > city_count) {
			System.out.println("\nSelect your starting city by entering the city index: ");
			startCity = scan.nextInt();
		}
		while (endCity< 0 || endCity > city_count) {
			System.out.println("Select your destination by entering the city index: ");
			endCity = scan.nextInt();
		}
		
		
		ArrayList<Integer> attractionList = new ArrayList<Integer>();
		int attraction_count = trip.attractionsInfo(attractions).size();
		
		
		System.out.println("142:Exit\n\nEnter the index of the attractions you want to visit\n enter 142 exit.");
		int x = -1;
		while (x != 142 || x < 142){
			x = scan.nextInt();
			if (x != 142 || x < 142) { 
				attractionList.add(x); 
			}
			
		}
		
		System.out.println("YOU SELECTED:\n\n");
		System.out.println("Starting City: "+trip.roadList.get(startCity).getCurrentCity()+", "+trip.roadList.get(startCity).getIndex());  //beginning city
		System.out.println("Ending City: "+trip.roadList.get(endCity).getCurrentCity()+", "+trip.roadList.get(endCity).getIndex()+"\n"); //ending city
		for (int i = 0; i < attractionList.size(); i++) {
			int pick = attractionList.get(i);
			System.out.print("Attraction "+(i+1)+": "+trip.attractionList.get(pick).getName()+", "+trip.attractionList.get(pick).getIndex()+"\n");
		}
		
		trip.route(startCity, endCity, attractionList);
	}
		
	



}


	