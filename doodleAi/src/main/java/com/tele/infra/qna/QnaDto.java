package com.tele.infra.qna;

import java.util.Date;

public class QnaDto {
	
	private String ifqnaSeq;
	private String ifqnaTitle;
	private Integer ifqnaCate;
    private String ifqnaDesc;
	private Date ifqnaDateTime;
	private Date ifqnaDateTimeEdit;
	private String member_ifmmSeq;
	
	//member
	private String ifmmSeq;
	private String ifmmNickName;
	private String ifmmId;
	
	//----- get set
	
	public String getIfqnaSeq() {
		return ifqnaSeq;
	}
	public void setIfqnaSeq(String ifqnaSeq) {
		this.ifqnaSeq = ifqnaSeq;
	}
	public String getIfqnaTitle() {
		return ifqnaTitle;
	}
	public void setIfqnaTitle(String ifqnaTitle) {
		this.ifqnaTitle = ifqnaTitle;
	}
	public Integer getIfqnaCate() {
		return ifqnaCate;
	}
	public void setIfqnaCate(Integer ifqnaCate) {
		this.ifqnaCate = ifqnaCate;
	}
	public String getIfqnaDesc() {
		return ifqnaDesc;
	}
	public void setIfqnaDesc(String ifqnaDesc) {
		this.ifqnaDesc = ifqnaDesc;
	}
	public Date getIfqnaDateTime() {
		return ifqnaDateTime;
	}
	public void setIfqnaDateTime(Date ifqnaDateTime) {
		this.ifqnaDateTime = ifqnaDateTime;
	}
	public Date getIfqnaDateTimeEdit() {
		return ifqnaDateTimeEdit;
	}
	public void setIfqnaDateTimeEdit(Date ifqnaDateTimeEdit) {
		this.ifqnaDateTimeEdit = ifqnaDateTimeEdit;
	}
	public String getMember_ifmmSeq() {
		return member_ifmmSeq;
	}
	public void setMember_ifmmSeq(String member_ifmmSeq) {
		this.member_ifmmSeq = member_ifmmSeq;
	}
	public String getIfmmSeq() {
		return ifmmSeq;
	}
	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}
	public String getIfmmNickName() {
		return ifmmNickName;
	}
	public void setIfmmNickName(String ifmmNickName) {
		this.ifmmNickName = ifmmNickName;
	}
	public String getIfmmId() {
		return ifmmId;
	}
	public void setIfmmId(String ifmmId) {
		this.ifmmId = ifmmId;
	}
	
}
