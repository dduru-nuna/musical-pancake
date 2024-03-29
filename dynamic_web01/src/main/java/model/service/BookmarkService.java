package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;
import paging.Paging;

public class BookmarkService {

	public boolean add(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		
		//url 추가시 id 도 생성되게 하는 법
		int id = dao.getId();
		dto.setId(id);
		
		int count = dao.insert(dto);
		if(count == 1) {
			dao.commit(); 
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public List<BookmarkDTO> getAll(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectAll(dto);
		dao.close();
		return data;
	}

	public BookmarkDTO getId(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		BookmarkDTO data = dao.selectId(dto);
		dao.close();
		return data;
	}

	public boolean update(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.update(dto);
		if(count == 1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public boolean delete(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.delete(dto);
		if(count == 1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}
                  //사용자별 정보를 얻기위해 dto 객체 필요
	public Paging getPage(BookmarkDTO dto, int pageNumber, int cnt) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageNumber -1) * cnt + 1);
		map.put("end", (pageNumber * cnt));
		map.put("userId", dto.getUserId());
		
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectPage(map);
		int count = dao.totalRowCount(dto); //사용자별 rowcount 다르기 때문에 dto 넘겨줌
		int lastPageNumber = (count / cnt) + (count % cnt == 0 ? 0 : 1);
		
		Paging paging = new Paging(data, pageNumber, lastPageNumber, cnt, 5);
		dao.close();
		return paging;
	}

}
