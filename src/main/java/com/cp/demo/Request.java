package com.cp.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reqId;
	@Column(name="date_send")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateSend;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="date_res")
	private Date dateRes;
	private String note;
	private float money;
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="reqt_id")
    private RequestType requestType;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="mem_id")
    private Member member;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="status_id")
    private Status status;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="off_id")
    private Officer officer;
	@JsonIgnore 
	@OneToOne(mappedBy="request", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private RecordTransaction recordTransaction;
	
	public RecordTransaction getRecordTransaction() {
		return recordTransaction;
	}
	public void setRecordTransaction(RecordTransaction recordTransaction) {
		this.recordTransaction = recordTransaction;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public Date getDateSend() {
		return dateSend;
	}
	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}
	public Date getDateRes() {
		return dateRes;
	}
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	
}
