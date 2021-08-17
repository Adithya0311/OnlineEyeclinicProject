package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.SpectacleIdNotFoundException;
import com.cg.dao.ISpectaclesRepo;
import com.cg.model.Spectacles;

@Service
public class SpectaclesServiceImpl implements ISpectaclesService{
 
	@Autowired
	private ISpectaclesRepo spectRepo;

	@Override
	public Spectacles addSpectacle(Spectacles spectacle) {
		// TODO Auto-generated method stub
		return spectRepo.saveAndFlush(spectacle);
	}

	@Override
	public Spectacles removeSpectacle(int spectacleId)throws SpectacleIdNotFoundException{
		Supplier<SpectacleIdNotFoundException> supplier=()->new SpectacleIdNotFoundException("no spectacle is available with given id");
		// TODO Auto-generated method stub
		Optional<Spectacles> s=Optional.ofNullable(spectRepo.findById(spectacleId).orElseThrow(supplier));
		spectRepo.deleteById(spectacleId);
		return s.get();
	}

	@Override
	public Spectacles updateSpectacle(Spectacles spectacle) {
		// TODO Auto-generated method stub
		return spectRepo.saveAndFlush(spectacle);
	}

	@Override
	public Spectacles getSpectacle(int spectacleId)throws SpectacleIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<SpectacleIdNotFoundException> supplier=()->new SpectacleIdNotFoundException("no spectacle is available with given id");
		Optional<Spectacles> s=Optional.ofNullable(spectRepo.findById(spectacleId).orElseThrow(supplier));
		return s.get();
	}

	@Override
	public List<Spectacles> getAllSpectacle() {
		// TODO Auto-generated method stub
		return spectRepo.findAll();
	}
}
