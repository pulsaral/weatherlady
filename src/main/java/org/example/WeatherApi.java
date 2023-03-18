package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherApi {
	
	// facebook.com/profile
	
	public static String getWeather(String cityName) {
	   // https://api.openweathermap.org/data/2.5/weather?q=Tirana&appid=921f774ae1e436501798051e22ea78db&units=metric
	    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=921f774ae1e436501798051e22ea78db&units=metric";
	  
	    
	    String weather = null;
	    try {
	        URL apiUrl = new URL(url);
	        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
	        conn.setRequestMethod("GET");
	        int responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            
	            String stringResponse = response.toString();
	            Gson gson = new Gson();
	            
	            WeatherApiResponse objectResponse =
	            		gson.fromJson(stringResponse, WeatherApiResponse.class);
	       
	            System.out.println("City: " + cityName);
	            System.out.println("Temperature: " + objectResponse.getMain().getTemp());
	            System.out.println("Humidity: " + objectResponse.getMain().getHumidity());
	            System.out.println("Wind speed: " + objectResponse.getWind().getSpeed());
	            System.out.println("Weather description: " + 
	             objectResponse.getWeather().get(0).getDescription());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return weather;
	}

}
