package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.repositories.DojoRepository;

@Service
public class DojoService {
	
private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
    // returns all the dojo
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    
    // creates a dojo
    public  Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionaDojo = dojoRepository.findById(id);
        if(optionaDojo.isPresent()) {
            return optionaDojo.get();
        } else {
            return null;
        }
    }
    
    // update
    public Dojo updateDojo(Dojo dojo) {	
		return dojoRepository.save(dojo);
	}
    
    
    // delete
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id); 	
    }
	


}
