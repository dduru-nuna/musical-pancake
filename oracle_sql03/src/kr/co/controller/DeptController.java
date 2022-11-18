package kr.co.controller;

import java.util.ArrayList;

import kr.co.dao.DeptDAO;
import kr.co.view.DeptView;
import kr.co.vo.DeptVO;

public class DeptController {

	private DeptDAO deptDao = new DeptDAO();
	private DeptView view = new DeptView();
	
	public void getAll() {
		ArrayList<DeptVO> datas = deptDao.selectAll();
		view.print(datas);
	}

}
