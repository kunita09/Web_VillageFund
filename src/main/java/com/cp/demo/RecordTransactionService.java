package com.cp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordTransactionService {
	@Autowired
	private RecordTransactionRepository recRepo;
	@Autowired
	private SactionTypeRepository sactRepo;
	
	public List<RecordTransaction> findAllRecord() {
		return (List<RecordTransaction>) recRepo.findAll();
	}

	public RecordTransaction findRecordById(int recId) {
		return (RecordTransaction) recRepo.findById(recId).get();
	}

	public void saveRecord(RecordTransaction rec) {
		recRepo.save(rec);
	}
	
	public List<SactionType> findAllSactionType() {
		return (List<SactionType>) sactRepo.findAll();
	}

	public SactionType findSactionTypeById(int sactId) {
		return (SactionType) sactRepo.findById(sactId).get();
	}

	public void saveRequest(SactionType sact) {
		sactRepo.save(sact);
	}
}
