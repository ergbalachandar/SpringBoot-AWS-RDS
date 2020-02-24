package io.java.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import io.java.dto.SquadDetails;

public interface SquadDetailsInterface extends JpaRepository <SquadDetails, String> {
	
	public List<SquadDetails> findByTribe(String tribe);

}
