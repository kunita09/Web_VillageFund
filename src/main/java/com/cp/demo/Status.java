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
@Table(name="status")
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="statusId")
	private int statusId;
	private String description;
	@JsonIgnore
	@OneToMany(targetEntity=Request.class, mappedBy="status",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Request> requests;
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
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
