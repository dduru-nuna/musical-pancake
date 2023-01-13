package model.service;

import java.util.List;

import model.dao.VisitDAO;
import model.dto.VisitDTO;

public class VisitService {

	public boolean add(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int count = dao.insert(dto);
		if(count == 1) {
			dao.commit();  //insert 후 커밋하고 작업 닫기
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public List<VisitDTO> getAll() {
		VisitDAO dao = new VisitDAO();
		List<VisitDTO> data = dao.selectAll();
		dao.close();
		return data;
	}

}
