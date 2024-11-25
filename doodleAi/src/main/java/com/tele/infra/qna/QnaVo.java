package com.tele.infra.qna;

import com.tele.common.constants.Constants;

public class QnaVo {
	
	private String shTitle;
	
	//페이징
	private int thisPage = 1;								//현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;	//화면에 보여질 데이터 줄 갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;	//화면에 보여질 페이지 번호 갯수
		
	private int totalRows;									//총 데이터 갯수	
	private int totalPages;									//총 페이지 갯수
	private int startPage;									//시작 페이지 번호
	private int endPage;									//마지막 페이지 번호
		
	private int startRnumForMysql = 0; 						//시작 쿼리 row
	//
	public void setParamsPaging(int totalRows) {

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		System.out.println("thispage: " + getThisPage());
		System.out.println("rowNumToShow: " + getRowNumToShow());
		System.out.println("pageNumToShow: " + getPageNumToShow());
		System.out.println("totalRows: " + getTotalRows());
		System.out.println("totalPages: " + getTotalPages());
		System.out.println("startPage: " + getStartPage());
		System.out.println("endPage: " + getEndPage());
		System.out.println("startRnumForMysql: " + getStartRnumForMysql());
	}
	
	//get , set
	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}

	public String getShTitle() {
		return shTitle;
	}

	public void setShTitle(String shTitle) {
		this.shTitle = shTitle;
	}
	
}
