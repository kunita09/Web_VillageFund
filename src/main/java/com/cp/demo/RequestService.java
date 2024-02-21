package com.cp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
	@Autowired
	private RequestRepository reqRepo;
	@Autowired
	private StatusRepository statusRepo;
	@Autowired
	private RequestTypeRepository reqTypeRepo;

	public List<Request> findAllRequest() {
		return (List<Request>) reqRepo.findAll();
	}

	public Request findRequestById(int reqId) {
		return (Request) reqRepo.findById(reqId).get();
	}

	public void saveRequest(Request req) {
		reqRepo.save(req);
	}
	
	public void updateRequest(Request req, Status status, Officer officer) {
		req.setStatus(status);
		req.setOfficer(officer);
		reqRepo.save(req);
	}

	public List<Request> findAllByStatusId(int statusId) {
		Status status = this.findStatusById(statusId);
		return (List<Request>) reqRepo.findByStatus(status);
	}

	public List<Request> findAllByReqTypeId(int reqTypeId) {
		RequestType reqType = this.findReqTypeById(reqTypeId);
		return (List<Request>) reqRepo.findByRequestType(reqType);
	}

	public List<RequestType> findAllRequestType() {
		return (List<RequestType>) reqTypeRepo.findAll();
	}

	public RequestType findReqTypeById(int reqTypeId) {
		return (RequestType) reqTypeRepo.findById(reqTypeId).get();
	}
	
	public List<Status> findAllStatus() {
		return (List<Status>) statusRepo.findAll();
	}

	public Status findStatusById(int statusId) {
		return (Status) statusRepo.findById(statusId).get();
	}
}
