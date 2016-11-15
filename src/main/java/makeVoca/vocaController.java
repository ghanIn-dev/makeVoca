package makeVoca;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vocaController {

	@Autowired
	vocaService vocaservice;
	
	@RequestMapping(value="/get")
	public String getSetence(){
			
		return "/getSentence";		
	}
	
	@RequestMapping(value="/set")
	public String setVoca(ModelMap map, @ModelAttribute vocaVO vo){

		String sentence = vo.getVoca();
					
		StringTokenizer st = new StringTokenizer(sentence);
		
		while(st.hasMoreTokens()){	
			vocaservice.insert(st.nextToken());
		}
			
		return "redirect:/view";		
	}
	
	
	@RequestMapping(value="/view")
	public String viewVoca(ModelMap map){
		
		List<?> viewword = vocaservice.vocaList();
		map.addAttribute("viewword",viewword);	
		
		return "/viewWord";		
	}
	
}
