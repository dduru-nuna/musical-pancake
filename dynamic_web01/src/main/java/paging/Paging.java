package paging;

import java.util.ArrayList;
import java.util.List;

public class Paging {

	/**
	 * 페이징 : 사용자에게 DB에 저장된 데이터 목록을 제공할 때 너무 많은 데이터를 제공하면 웹 서버나
	 *        DB서버에 부하가 발생할 수 있기 때문에 이를 페이지 단위로 나누어 제공하기 위해 사용한다.
	 *        
	 * 페이징 기능을 위해 Oracle 을 사용하는 경우 Top N 분석을 활용하여 원하는 수량만 조회하게 한다.
	 * Mybatis 의 기능 중 Cursor 기능을 활용하여 페이징 기능을 구현할 수도 있다.
	 * ( selectCursor("네임스페이스명.아이디", 전달할파라메터, RowBounds객체) )
	 */
	
	private Object data;  //화면에 출력할 페이지 데이터(TopN 조회 쿼리로 조회한 데이터), 모든 객체를 담을 수 있게 object 로 설정
	private List<Integer> pageList; //전체 페이지 번호가 있는 리스트
	private int currentPageNumber = 1;  //현재 페이지 번호 (초기값 1)
	private int lastPageNumber;  //마지막 페이지 번호
	private int pageLimit = 10;  //화면에 출력할 목록 제한 수 (초기값 10)
	private int listLimit = 5;  //화면에 출력할 페이지 번호 제한 수 (초기값 5)
	
	public Paging(Object data, int lastPageNumber) { 
		this(data, 1, lastPageNumber);
		setPageList();
	}
	
	private Paging(Object data, int currentPageNumber, int lastPageNumber) {
		this.data = data;
		this.lastPageNumber = lastPageNumber;
		this.currentPageNumber = currentPageNumber;
		
	}
	
	public Paging(Object data, int currentPageNumber, int lastPageNumber, int pageLimit, int listLimit) {
		this(data, currentPageNumber, lastPageNumber); //위에 있는 생성자 호출됨. 거기서 설정 후 pageLimit설정, listLimit설정 마지막에 setPageList 실행
		this.pageLimit = pageLimit;
		this.listLimit = listLimit;
		setPageList();
	}
	
	private void setPageList() {  //생성자 통해 생성할 때만 만들어지게 private
		// 현재 페이지 번호, 마지막 페이지 번호, 페이지 번호 제한 수 를 이용하여 페이지 번호 목록 생성
		// 현재 페이지 번호 : 1, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5 => [1,2,3,4,5]
		// 현재 페이지 번호 : 7, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5 => [7,8,9,10]
		
		/*
		this.pageList = new ArrayList<Integer>();
		int max = this.currentPageNumber + this.listLimit - 1;
		if(max > this.lastPageNumber) {
			max = this.lastPageNumber; //마지막 페이지 번호 넘어가지 못하게 설정
		}
		for(int i = this.currentPageNumber; i <= max; i++) {
			pageList.add(i);
		}
		*/
		//활성화 페이지 가운데 배치
		int start = 1;
		int end = listLimit;
		if(currentPageNumber > (listLimit / 2)) {
			start = currentPageNumber - (listLimit / 2);
		}
		end = start + listLimit - 1;
		
		if(end > lastPageNumber) {
			end = lastPageNumber;
		}
		
		this.pageList = new ArrayList<Integer>();
		for(int i = start; i <= end; i++) {
			pageList.add(i);
		}
		
	}
	
	public List<Integer> getPageList() {
		return this.pageList;
	}
	
	public Object getData() {
		return data;
	}
	
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	
	public int getPrevPageNumber() {
		int prevPage = currentPageNumber - 1;
		//현재 페이지가 1이라 이전페이지가 0 인 경우를 '-1' 로 반환(잘못된 요청임을 구분)
		return prevPage == 0 ? -1 : prevPage;
	}
	
	public int getNextPageNumber() {
		int nextPage = currentPageNumber + 1;
		//현재 페이지가 마지막 페이지라 다음 페이지가 없는 경우를 '-1' 로 반환(잘못된 요청임을 구분)
		return nextPage > lastPageNumber ? -1 : nextPage;
	}
	
	public int getLastPageNumber() {
		return lastPageNumber;
	}
	
	public int getPageLimit() {
		return pageLimit;
	}
}	
