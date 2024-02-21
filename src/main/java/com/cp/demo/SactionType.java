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
@Table(name="sactiontypes")
public class SactionType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sactId")
	private int sactId;
	private String description;
	@JsonIgnore
	@OneToMany(targetEntity=RecordTransaction.class, mappedBy="sactionType",
    		cascade=CascadeType.ALL)
	private List<RecordTransaction> recordTransaction;
	
	public int getSactId() {
		return sactId;
	}
	public void setSactId(int sactId) {
		this.sactId = sactId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<RecordTransaction> getRecordTransaction() {
		return recordTransaction;
	}
	public void setRecordTransaction(List<RecordTransaction> recordTransaction) {
		this.recordTransaction = recordTransaction;
	}

}
