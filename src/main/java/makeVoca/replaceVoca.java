package makeVoca;

public class replaceVoca {
	
	public String reVoca(String word){
		
		word = word.replaceAll("[0-9]", "");
		word = word.replace("." , "");
		//word = word.replace("'" , "");
		word = word.replace("-" , "");
		word = word.replace("," , "");
		word = word.replace(":" , "");
		word = word.replace("!" , "");
		
		
		return word;
	}

}
