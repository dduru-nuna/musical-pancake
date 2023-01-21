package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.VisitDAO;
import model.dto.VisitDTO;

public class VisitService {

	public boolean add(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		
		int id = dao.getId();
		dto.setId(id);
		
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
	
	public VisitDTO getId(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		VisitDTO data = dao.selectId(dto);
		dao.close();
		return data;
	}
	
	public boolean update(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int count = dao.update(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}
	
	public boolean delete(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int count = dao.delete(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}
	
	public List<VisitDTO> getPage(int pageNumber, int cnt) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (pageNumber - 1) * cnt + 1);
		map.put("end", (pageNumber * cnt));
		
		VisitDAO dao = new VisitDAO();
		List<VisitDTO> data = dao.selectPage(map);
		dao.close();
		return data;
	}
	
	public int totalRow() {
		VisitDAO dao = new VisitDAO();
		int count = dao.totalRowCount();
		dao.close();
		return count;
	}
}
