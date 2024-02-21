package com.cp.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recordtransaction")
public class RecordTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tranId")
	private int tranId;
	private float money;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "sactId")
	private SactionType sactionType;
	@JsonIgnore 
	@ManyToOne(optional=false)
	@JoinColumn(name="memId")
    private Member member;
	@JsonIgnore 
	@ManyToOne(optional=false)
	@JoinColumn(name="offId")
    private Officer officer;
	
	@OneToOne
    @JoinColumn(name = "req_id")
	private Request request;

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SactionType getSactionType() {
		return sactionType;
	}

	public void setSactionType(SactionType sactionType) {
		this.sactionType = sactionType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
