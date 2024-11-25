package com.tele.infra.comm;

import java.util.Date;

public class CommDto {
	
	private String ifdrSeq;
	private String ifdrTitle;
	private String ifdrDesc;
	private Date ifdrDateTime;
	private Date ifdrDateTimeEdit;
	private Integer ifdrDelNy;
	private Integer ifdrOpenNy;
	private String member_ifmmSeq;
	
	//member
	private String ifmmSeq;
	private String ifmmName;
	private String ifmmNickName;
	private String ifmmId;
	// get , set
	public String getIfdrSeq() {
		return ifdrSeq;
	}
	public void setIfdrSeq(String ifdrSeq) {
		this.ifdrSeq = ifdrSeq;
	}
	public String getIfdrTitle() {
		return ifdrTitle;
	}
	public void setIfdrTitle(String ifdrTitle) {
		this.ifdrTitle = ifdrTitle;
	}
	public String getIfdrDesc() {
		return ifdrDesc;
	}
	public void setIfdrDesc(String ifdrDesc) {
		this.ifdrDesc = ifdrDesc;
	}
	public Date getIfdrDateTime() {
		return ifdrDateTime;
	}
	public void setIfdrDateTime(Date ifdrDateTime) {
		this.ifdrDateTime = ifdrDateTime;
	}
	public Date getIfdrDateTimeEdit() {
		return ifdrDateTimeEdit;
	}
	public void setIfdrDateTimeEdit(Date ifdrDateTimeEdit) {
		this.ifdrDateTimeEdit = ifdrDateTimeEdit;
	}
	public Integer getIfdrDelNy() {
		return ifdrDelNy;
	}
	public void setIfdrDelNy(Integer ifdrDelNy) {
		this.ifdrDelNy = ifdrDelNy;
	}
	public Integer getIfdrOpenNy() {
		return ifdrOpenNy;
	}
	public void setIfdrOpenNy(Integer ifdrOpenNy) {
		this.ifdrOpenNy = ifdrOpenNy;
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
	public String getIfmmName() {
		return ifmmName;
	}
	public void setIfmmName(String ifmmName) {
		this.ifmmName = ifmmName;
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
