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
	
	// 문장 입력
	@RequestMapping(value="/get")
	public String getSetence(){
			
		return "/getSentence";		
	}
	// 문장을 단어로 분류한 후 db에 저장
	@RequestMapping(value="/set")
	public String setVoca(ModelMap map, @ModelAttribute vocaVO vo){
	
		String sentence = vo.getVoca(); //입력 문장		
		FetchMeanings meanings = new FetchMeanings(); // 사전 클래스 초기화
		replaceVoca replaceVoca = new replaceVoca(); // 문장 정리 클래스 초기화
		sentence = replaceVoca.reVoca(sentence); // 문장 정리
		StringTokenizer st = new StringTokenizer(sentence); // 입력 문장을 단어로 분해
				
		//List listA = new ArrayList();
				
		while(st.hasMoreTokens()){	// 분해한 단어의 갯수 만큼
			
			String voca=st.nextToken(); // 현재 단어
			String meanfind = meanings.fetchMeanings(voca).toString(); // 현재 단어에 대한 의미

			vo.setVoca(voca);
			vo.setMean(meanfind);
			//listA.add(vo);
			vocaservice.insert(vo);
					
		}
			 
/*		map.addAttribute("viewword",listA);	
		return "/viewWord";	*/
		return "redirect:/view";		
	}
	
	//리스트 출력
	@RequestMapping(value="/view")
	public String viewVoca(ModelMap map){
		
		List<?> viewword = vocaservice.vocaList();
		
		map.addAttribute("viewword",viewword);	
		
		return "/viewWord";		
	}
	
	//삭제
	@RequestMapping(value= "/del")
	public String delVoca(@ModelAttribute vocaVO vo){
		
		String delWord = vo.getVoca();
		
		vocaservice.deleteWord(delWord);
		
		return "redirect:/view";	
	}
	
}
