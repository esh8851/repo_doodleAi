package com.tele.infra.dreams;

import java.util.Date;

public class DreamsDto {

	private String ifdmSeq;
	private String ifdmTitle;
	private String ifdmDesc;
	private Date ifdmDateTime;
	private Date ifdmDateTimeEdit;
	private String member_ifmmSeq;
//	-----
	public String getIfdmSeq() {
		return ifdmSeq;
	}
	public void setIfdmSeq(String ifdmSeq) {
		this.ifdmSeq = ifdmSeq;
	}
	public String getIfdmTitle() {
		return ifdmTitle;
	}
	public void setIfdmTitle(String ifdmTitle) {
		this.ifdmTitle = ifdmTitle;
	}
	public String getIfdmDesc() {
		return ifdmDesc;
	}
	public void setIfdmDesc(String ifdmDesc) {
		this.ifdmDesc = ifdmDesc;
	}
	public Date getIfdmDateTime() {
		return ifdmDateTime;
	}
	public void setIfdmDateTime(Date ifdmDateTime) {
		this.ifdmDateTime = ifdmDateTime;
	}
	public Date getIfdmDateTimeEdit() {
		return ifdmDateTimeEdit;
	}
	public void setIfdmDateTimeEdit(Date ifdmDateTimeEdit) {
		this.ifdmDateTimeEdit = ifdmDateTimeEdit;
	}
	public String getMember_ifmmSeq() {
		return member_ifmmSeq;
	}
	public void setMember_ifmmSeq(String member_ifmmSeq) {
		this.member_ifmmSeq = member_ifmmSeq;
	}
	
	
	
}
