package com.cp.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer>{
	List<Request> findByStatus(Status status);
	List<Request> findByRequestType(RequestType reqType);
}
