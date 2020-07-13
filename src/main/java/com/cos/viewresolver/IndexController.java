package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller //IoC
public class IndexController { 
	
	@GetMapping({"","/"})
	public  String index(Model model) {
		
		String name ="cos"; 
		String password ="1234";
		int num = 10;
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("num",num);
		//=>viewresolver/src/main/resources/templates/index.mustache
		return "index";
	}
	
	@GetMapping("/model/data") 
	public String modelData(Model model) {
		
		Member member = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01077777777")
				.build();
		  model.addAttribute("member", member);
		  
		return "modelData";
	}
	@GetMapping("/model/array") 
	public String modelArray(Model model) {
		
		Member member1 = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01077777777")
				.build();
	
			
	    Member member2 = Member.builder()
					.id(2)
					.username("cos")
					.phone("01011111111")
					.build();
	
		List<Member> members = new ArrayList<>();
		members.add(member1); 
		members.add(member2);
		model.addAttribute("members", members);
		model.addAttribute("user", true);
		  
		return "modelArray";
	}
      @GetMapping("/layout")
      public String layout() {
    	  return "layout";
      }
}
