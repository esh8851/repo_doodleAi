package com.tele.infra.diary;

import java.util.Date;

public class DiaryDto {
	
	private String ifdrSeq;
	private String ifdrTitle;
	private String ifdrDesc;
	private Date ifdrDateTime;
	private Date ifdrDateTimeEdit;
	private Integer ifdrDelNy;
	private Integer ifdrOpenNy;
	private String member_ifmmSeq;
	
	
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
	

}
