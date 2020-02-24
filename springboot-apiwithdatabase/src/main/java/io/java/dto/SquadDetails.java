package io.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SQUADDETAILS")
public class SquadDetails {
	
	@Id
	private String name;
	@Column
	private String tribe;
	@Column
	private String numberOfPeople;
	
	
	

}
