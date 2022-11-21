package kr.co.view;

import java.util.ArrayList;

import kr.co.vo.DeptVO;

public class DeptView {

	public void print(ArrayList<DeptVO> datas) {
		for(DeptVO dept: datas) {
			System.out.println(dept);
		}
	}

}
