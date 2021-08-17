package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.SpectacleIdNotFoundException;
import com.cg.model.Spectacles;

@Service
public interface ISpectaclesService {
	//add spectacle
		public Spectacles addSpectacle(Spectacles spectacle);

		//remove spectacle
		public Spectacles removeSpectacle(int spectacleId)throws SpectacleIdNotFoundException; 

		//update spectacle
		public Spectacles updateSpectacle(Spectacles spectacle);

		//get spectacle
		public Spectacles getSpectacle(int spectacleId)throws SpectacleIdNotFoundException;

		//get spectacle list
		public List<Spectacles> getAllSpectacle();
		
		
}
