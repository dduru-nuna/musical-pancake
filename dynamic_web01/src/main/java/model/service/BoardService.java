package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
import paging.Paging;

public class BoardService {

	public Paging getPage(int pageNumber, int pageLimit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageNumber - 1) * pageLimit + 1);
		map.put("end", pageNumber *  pageLimit);
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> data = dao.selectPage(map);
		int totalRowCount = dao.totalRowCount();
		int lastPageNumber = (totalRowCount / pageLimit) + (totalRowCount % pageLimit == 0 ? 0 : 1);
		
		Paging paging = new Paging(data, pageNumber, lastPageNumber, pageLimit, 5);
		return paging;
	}

}
