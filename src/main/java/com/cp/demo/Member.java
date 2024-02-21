package com.cp.demo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	@Id
	@Column(name="memId")
	private String memId;
	@Column(name="password")
	private String password;
	private String fname;
	private String lname;
	private String phone;
	private String address;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="dateReg")
	private Date dateReg;
	@Column(name="depositAmount")
	private float depositAmount;
	
	@JsonIgnore
	@OneToMany(targetEntity=Request.class, mappedBy="member",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Request> requests;
	@JsonIgnore
	@OneToMany(targetEntity=RecordTransaction.class, mappedBy="member",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecordTransaction> recordTransaction;
	
	public List<RecordTransaction> getRecordTransaction() {
		return recordTransaction;
	}
	public void setRecordTransaction(List<RecordTransaction> recordTransaction) {
		this.recordTransaction = recordTransaction;
	}
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateReg() {
		return dateReg;
	}
	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}
	public float getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(float depositAmount) {
		this.depositAmount = depositAmount;
	}
	
}
