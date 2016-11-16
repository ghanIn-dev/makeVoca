package makeVoca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

public class FetchMeanings {
	
	public String fetchMeanings(String word){
		ArrayList<String> meanings = new ArrayList<String>();
		String kormean = null;

		try{
			URL url = new URL("https://glosbe.com/gapi/translate?from=eng&dest=kor&format=json&phrase="+word.toLowerCase()+"&pretty=true");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

	        String inputLine;
	        String urlContents="";
	        
	        
	        while ((inputLine = in.readLine()) != null)
	        		if(!urlContents.equals(""))
	        			urlContents=urlContents+"\n"+inputLine;
	        		else
	        			urlContents=urlContents+inputLine;
	        in.close();
	        
	        kormean = urlContents.replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "/");
	        StringTokenizer st= new StringTokenizer(kormean,"/");
	        
	        for (int i = 0; i<4; i++) {
				
	        	meanings.add(st.nextToken());
			}    	

	        
	/*        
	        if(urlContents.contains("tuc")){
	        	JsonValue value = Json.parse(urlContents);
			    JsonArray meaningList = value.asObject().get("tuc").asArray().get(0).asObject().get("meanings").asArray();
			    int i=1;
			    for (JsonValue item : meaningList){
			        String meaning = item.asObject().get("text").asString();
			        if(!meanings.contains("Meaning "+i+": "+meaning))
			        	meanings.add("Meaning "+i+++": "+meaning);
			    }
	        }
	        else{
	        	meanings.add("Sorry we do not have meaning for the word. Are you sure about the spelling of the word?");
	        }
	        
	        */
	        
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
		return meanings.toString();
	}

}
