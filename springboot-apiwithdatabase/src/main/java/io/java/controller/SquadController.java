package io.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.java.dto.SquadDetails;
import io.java.services.SquadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController

@RequestMapping("/squad")
@Api(value="SquadDetails", description="Details of Squad in Tribe")
public class SquadController {
	
	@Autowired
	SquadService squadService;
	
	/**
	 * Method to insert the details of squad
	 * @param squadDetails
	 */
	@RequestMapping(method=RequestMethod.POST,value = "/squadDetails")
	@ApiOperation(value = "Add Squad Details")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	public ResponseEntity insertSquadDetails(@RequestBody SquadDetails squadDetails){		
		squadService.insertSquadDetails(squadDetails);		
		 return new ResponseEntity("Squad Details Added Successfully", HttpStatus.OK);
	}
	
	/**
	 * Method to retrieve the details of the squad
	 * @param name
	 * @return squadDetails
	 */
	@ApiOperation(value = "Search for Squad with a squadName",response = SquadDetails.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(method=RequestMethod.GET,value="/squadDetails/{name}")
	public SquadDetails getSquadDetails(@PathVariable String name){
		return squadService.getSquadDetails(name);	
	}
	/**
	 * Method to retrieve all the squadDetails from DB
	 * @return List<squadDetails>
	 */
	@ApiOperation(value = "List of Squad Details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(method=RequestMethod.GET,value="/squadDetails")
	public List<SquadDetails> getAllSquadDetails(){
		return squadService.getAllSquadDetails();	
	}
	
	/**
	 * Method to update the squadDetails
	 * @return List<squadDetails>
	 */
	 @ApiOperation(value = "Update Squad Details")
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully Updated squad details"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	    @RequestMapping(value = "/update/{squadName}", method = RequestMethod.PUT, produces = "application/json")
	    public ResponseEntity updateSquadDetails(@PathVariable String squadName, @RequestBody SquadDetails squadDetails){
		 	SquadDetails storedSquad = squadService.getSquadDetails(squadName);
		 	storedSquad.setNumberOfPeople(squadDetails.getNumberOfPeople());
		 	storedSquad.setTribe(squadDetails.getTribe());
		 	squadService.insertSquadDetails(squadDetails);
	        return new ResponseEntity("Squad updated successfully", HttpStatus.OK);
	    }

	 
	 	/**
		 * Method to delete the squadDetails
		 * @return List<squadDetails>
		 */
		 
		 @ApiResponses(value = {
		            @ApiResponse(code = 200, message = "Successfully deleted squad details"),
		            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		    }
		    )
	    @ApiOperation(value = "Delete a Squad")
	    @RequestMapping(value="/delete/{squadName}", method = RequestMethod.DELETE, produces = "application/json")
	    public HttpStatus delete(@PathVariable String squadName){
	        squadService.deleteSquadDetails(squadName);
	        return  HttpStatus.OK;
	    }
		 
		 /**
			 * Method to retrieve the details of the squad
			 * @param name
			 * @return squadDetails
			 */
		 @ApiOperation(value = "List of Squad Details respective to Tribe")
		    @ApiResponses(value = {
		            @ApiResponse(code = 200, message = "Successfully retrieved list"),
		            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		    }
		    )
			@RequestMapping(method=RequestMethod.GET,value="/squadDetailsOfTribes/{tribe}")
			public List<SquadDetails> getSquadDetailsWithoutPrimaryKey(@PathVariable String tribe){
				return squadService.getSquadDetailsWithoutPrimaryKey(tribe);	
			}
			
	

}
