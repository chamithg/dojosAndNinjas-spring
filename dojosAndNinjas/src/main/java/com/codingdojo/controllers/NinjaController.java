package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;
import com.codingdojo.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	
	@GetMapping("/ninja")
    public String addNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojos", dojos);
        return "addNinja.jsp";
    }
	
	
	@PostMapping("/ninjas/add")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Ninja> ninjas = ninjaService.allNinjas();
        	List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("ninjas", ninjas);
			model.addAttribute("dojos", dojos);
            return "addNinja.jsp";
        } else {
       
			ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }


}
