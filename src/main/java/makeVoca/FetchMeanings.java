package makeVoca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FetchMeanings {

	public String fetchMeanings(String word) {
		ArrayList<String> meanings = new ArrayList<String>();
		String kormean = null;

		try {
			URL url = new URL("https://glosbe.com/gapi/translate?from=eng&dest=kor&format=json&phrase="
					+ word.toLowerCase() + "&pretty=true");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;
			String urlContents = "";
			String token = null;

			while ((inputLine = in.readLine()) != null)
				if (!urlContents.equals(""))
					urlContents = urlContents + "\n" + inputLine;
				else
					urlContents = urlContents + inputLine;
			in.close();
			
			//한글만 추출
			kormean = urlContents.replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "/");
			StringTokenizer st = new StringTokenizer(kormean, "/");

			
			// 검색결과 단어가 있는 지 확인 후 추가
			if (st.countTokens() == 0){
				token = "해당단어는 사전에 존재하지 않습니다.";
				meanings.add(token);
			} else{
				
				for (int i = 0; i < 4; i++) {
					token = st.nextToken();
					meanings.add(token);
				}
			}
		

			/*
			 * if(urlContents.contains("tuc")){ JsonValue value =
			 * Json.parse(urlContents); JsonArray meaningList =
			 * value.asObject().get("tuc").asArray().get(0).asObject().get(
			 * "meanings").asArray(); int i=1; for (JsonValue item :
			 * meaningList){ String meaning =
			 * item.asObject().get("text").asString();
			 * if(!meanings.contains("Meaning "+i+": "+meaning))
			 * meanings.add("Meaning "+i+++": "+meaning); } } else{ meanings.
			 * add("Sorry we do not have meaning for the word. Are you sure about the spelling of the word?"
			 * ); }
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return meanings.toString();
	}

}
