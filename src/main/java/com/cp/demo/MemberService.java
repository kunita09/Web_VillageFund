package com.cp.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memRepo;
	
	public boolean isExistByMemberId(String memId) {
		Optional mem = memRepo.findById(memId);
		return mem.isEmpty();
	}
	
	public List<Member> findAllMember(){
		return (List<Member>) memRepo.findAll();
	}

	public Member findMemberById(String memId) {
		return (Member) memRepo.findById(memId).get();
	}
	
	public void saveMember(Member mem) {
		memRepo.save(mem);
	}
	
	public void deleteMember(String memId) {
		Member mem = memRepo.findById(memId).get();
		memRepo.delete(mem);
	}
	
	public void updateMember(String memId, String fname, String lname) {
		Member mem = memRepo.findById(memId).get();
		mem.setFname(fname);
		mem.setLname(lname);
		memRepo.save(mem);
	}
	public void insertMember(Member mem) {
		memRepo.save(mem);
	}
}
