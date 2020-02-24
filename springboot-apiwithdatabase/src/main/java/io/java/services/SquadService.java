package io.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.dto.SquadDetails;
import io.java.interfaces.SquadDetailsInterface;

@Service
public class SquadService {
	
	@Autowired
	SquadDetailsInterface squadDetailsInterface;
	
	/**
	 * method to save the squadDetails in DB
	 * @param squadDetails
	 */
	public void insertSquadDetails(SquadDetails squadDetails){		
		squadDetailsInterface.save(squadDetails);		
	}
	
	/**
	 * Method to find the squadDetails based on the input
	 * @return
	 */
	public SquadDetails getSquadDetails(String name){		
		return squadDetailsInterface.findOne(name);
	}
	
	/**
	 * Method to find all the squadDetails from DB
	 * @return squadDetailsList
	 */
	public List<SquadDetails> getAllSquadDetails(){
		List<SquadDetails> squadDetailsList = new ArrayList<SquadDetails>();
		squadDetailsInterface.findAll().forEach(squadDetailsList::add);
		return squadDetailsList;
		
	}

	/**
	 * method to delete the squadDetails in DB
	 * @param squadDetails
	 */
	public void deleteSquadDetails(String squadName){		
		squadDetailsInterface.delete(squadName);		
	}
	
	/**
	 * Method to find the squadDetails based on the input other than primary key
	 * @return
	 */
	public List<SquadDetails> getSquadDetailsWithoutPrimaryKey(String name){
		List<SquadDetails> squadDetailsList = new ArrayList<SquadDetails>();
		 squadDetailsInterface.findByTribe(name).forEach(squadDetailsList::add);;
		 return squadDetailsList;
	}
	

}
