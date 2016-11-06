package makeVoca;

import java.util.List;

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
		
		stringToken stringToken = new stringToken();
		
		String sentence = vo.getVoca();
		List<?> vocaList = stringToken.makeList(sentence);	

		map.addAttribute("vocaList",vocaList);
		
		vocaservice.insert(vo);
			
		return "/viewWord";		
	}
	
}
