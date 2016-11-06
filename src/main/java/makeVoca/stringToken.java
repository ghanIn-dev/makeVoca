package makeVoca;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class stringToken {

	public List<?> makeList(String sentence){
		
		
		List<String> vocaList = new ArrayList<String>();
		
		StringTokenizer st = new StringTokenizer(sentence);
		
		while(st.hasMoreTokens()){
			vocaList.add(st.nextToken());
		}
		
		return vocaList;
	}
	
}
