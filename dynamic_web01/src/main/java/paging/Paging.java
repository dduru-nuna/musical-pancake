package paging;

import java.util.ArrayList;
import java.util.List;

public class Paging {

	private Object data;  //화면에 출력할 페이지 데이터(TopN 조회 쿼리로 조회한 데이터), 모든 객체를 담을 수 있게 object 로 설정
	private List<Integer> pageList; //전체 페이지 번호가 있는 리스트
	private int currentPageNumber = 1;  //현재 페이지 번호 (초기값 1)
	private int lastPageNumber;  //마지막 페이지 번호
	private int pageLimit = 10;  //화면에 출력할 목록 제한 수 (초기값 10)
	private int listLimit = 5;  //화면에 출력할 페이지 번호 제한 수 (초기값 5)
	
	public Paging(Object data, int lastPageNumber) { //여기서는 기본 현재 페이지번호 1
		this.data = data;
		this.lastPageNumber = lastPageNumber;
		setPageList();  //페이지 데이터와 마지막 페이지 번호만 알면 pageList 설정 가능
	}
	//실제 현재 페이지 설정 필요
	public Paging(Object data, int currentPageNumber, int lastPageNumber) {
		this(data, lastPageNumber);
		this.currentPageNumber = currentPageNumber;
	}
	//실제 현재 페이지 설정 필요
	public Paging(Object data, int currentPageNumber, int lastPageNumber, int pageLimit, int listLimit) {
		this(data, currentPageNumber, lastPageNumber);
		this.pageLimit = pageLimit;
		this.listLimit = listLimit;
	}
	
	private void setPageList() {  //생성자 통해 생성할 때만 만들어지게 private
		// 현재 페이지 번호, 마지막 페이지 번호, 페이지 번호 제한 수 를 이용하여 페이지 번호 목록 생성
		// 현재 페이지 번호 : 1, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5 => [1,2,3,4,5]
		// 현재 페이지 번호 : 7, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5 => [7,8,9,10]
		this.pageList = new ArrayList<Integer>();
		int max = this.currentPageNumber + this.listLimit - 1;
		if(max > this.lastPageNumber) {
			max = this.lastPageNumber; //마지막 페이지 번호 넘어가지 못하게 설정
		}
		for(int i = this.currentPageNumber; i <= max; i++) {
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
}	
