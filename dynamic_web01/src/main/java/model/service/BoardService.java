package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
import model.dto.BoardImageDTO;
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
		dao.close();
		
		Paging paging = new Paging(data, pageNumber, lastPageNumber, pageLimit, 5);
		return paging;
	}

	public BoardDTO getData(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		BoardDTO data = dao.selectData(dto);
        dao.close();
		return data;
	}
	
	public boolean upViewCnt(BoardDTO dto) {  //controller 에서 boolean 값 따로 저장 안하니 반환값 없도록 void 로 변경 가능
		BoardDAO dao = new BoardDAO();
		int count = dao.updateViewCnt(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean add(BoardDTO dto, List<BoardImageDTO> boardImageList) {
		BoardDAO dao = new BoardDAO();
		int id = dao.selectNextSeq();
		dto.setId(id);
		int count = dao.insert(dto);
		if(count == 1) {
			for(BoardImageDTO image: boardImageList) {
				image.setBoardId(id);
				dao.insertImage(image);
			}
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean updateData(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		int count = dao.update(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean delete(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		dao.deleteImages(dto);
		int count = dao.delete(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}
	
	public int delete(List<Integer> arrId) {
		BoardDAO dao = new BoardDAO();
		int count = dao.delete(arrId);
		if(count <= arrId.size()) {
			dao.commit(); dao.close();
			return count;
		}
		dao.rollback(); dao.close();
		return -1;
	}

	public boolean upGood(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		int count = dao.upGoodCnt(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean upBad(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		int count = dao.upBadCnt(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public void downGood(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		int count = dao.downGoodCnt(dto);
		if(count == 1) {
			dao.commit(); dao.close();
		}
		dao.rollback(); dao.close();
	}

	public void downBad(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		int count = dao.downBadCnt(dto);
		if(count == 1) {
			dao.commit(); dao.close();
		}
		dao.rollback(); dao.close();
	}

	public List<BoardImageDTO> getImages(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		List<BoardImageDTO> data = dao.selectImages(dto);
		dao.close();
		return data;
	}
}
