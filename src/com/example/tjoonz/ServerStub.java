package com.example.tjoonz;

import java.text.DecimalFormat;
import java.util.HashMap;

public class ServerStub {

	HashMap<String,UserInfo> data;
	
	public ServerStub(){
		
		data = new HashMap<String,UserInfo>();
	}
	
	 
	public void genMarkersInfo(int nbAleat){
		
		this.createAndAddUserInfo("Iduine", "Song1", 48.115195, -1.640156);
		this.createAndAddUserInfo("Okazari", "Song2", 48.115219, -1.640072);
		this.createAndAddUserInfo("Cisco", "Song3", 48.115198, -1.639971);
		this.createAndAddUserInfo("Zev", "Song1", 48.115265, -1.640042);

		for (int i=0; i<nbAleat ; i++){
			
			double minLat = -90.00;
		    double maxLat = 90.00;      
		    double latitude = minLat + (double)(Math.random() * ((maxLat - minLat) + 1));
		    double minLon = 0.00;
		    double maxLon = 180.00;     
		    double longitude = minLon + (double)(Math.random() * ((maxLon - minLon) + 1));
		    DecimalFormat df = new DecimalFormat("#.#####");
			this.createAndAddUserInfo(Integer.toString(i), "Song"+Integer.toString(i), latitude, longitude);
		}		
	}
	
	public HashMap<String, UserInfo> getData() {
		return data;
	}
	
	private void createAndAddUserInfo(String username, String currentSong, double latitude, double longitude){
		
		data.put(username, new UserInfo(username, currentSong, latitude, longitude));
		
	}
	
	public static void main(String[] args){
		
		ServerStub ss = new ServerStub();
		ss.genMarkersInfo(5);
		HashMap<String, UserInfo> hm = ss.getData();
		for(String key: hm.keySet()){
			System.out.println(hm.get(key).toString());
		}
		
	}
	
}