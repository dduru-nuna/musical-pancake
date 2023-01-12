package model.service;

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

}
