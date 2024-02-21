package com.cp.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="requesttypes")
public class RequestType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reqtId")
	private int reqtId;
	private String description;
	@JsonIgnore
	@OneToMany(targetEntity=Request.class, mappedBy="requestType",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Request> requests;
	
	public int getReqtId() {
		return reqtId;
	}
	public void setReqtId(int reqtId) {
		this.reqtId = reqtId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
}
