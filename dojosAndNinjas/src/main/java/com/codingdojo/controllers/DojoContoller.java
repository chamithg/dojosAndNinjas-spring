package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;

@Controller
public class DojoContoller {
	
	@Autowired
	DojoService dojoService;
	
	@RequestMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/")
    public String showDojos(@ModelAttribute("dojo") Dojo dojo,Model model) {
		List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "dashboard.jsp";
    }
	
	@GetMapping("/dojo/{id}")
    public String showSingleDojo(@PathVariable("id") Long id, Model model) {
		List<Ninja> ninjas = dojoService.findDojo(id).getNinjas();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojo",dojoService.findDojo(id).getName());
        return "dojoShow.jsp";
    }
	
	
	@PostMapping("/dojos/add")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
            return "dashboard.jsp";
        } else {
           
			dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }

}
