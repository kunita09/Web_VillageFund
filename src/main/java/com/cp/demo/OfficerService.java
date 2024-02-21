package com.cp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {
	@Autowired
	private OfficerRepository offRepo;
	
	public List<Officer> findAllOfficer(){
		return (List<Officer>) offRepo.findAll();
	}

	public Officer findOfficerById(String offId) {
		return (Officer) offRepo.findById(offId).get();
	}
	
	public void saveOfficer(Officer off) {
		offRepo.save(off);
	}
	
	public void deleteOfficer(String memId) {
		Officer off = offRepo.findById(memId).get();
		offRepo.delete(off);
	}
	
	public void updateOfficer(String memId, String fname, String lname) {
		Officer off = offRepo.findById(memId).get();
		off.setFname(fname);
		off.setLname(lname);
		offRepo.save(off);
	}
	public void insertOfficer(Officer off) {
		offRepo.save(off);
	}
}
