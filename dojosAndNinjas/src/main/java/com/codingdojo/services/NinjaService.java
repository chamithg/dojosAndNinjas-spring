package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	
private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
    // returns all the ninja
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
    
    // creates a ninja
    public  Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    // update
    public Ninja updateNinja(Ninja ninja) {	
		return ninjaRepository.save(ninja);
	}
    
    
    // delete
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id); 	
    }
    
    
}
	
