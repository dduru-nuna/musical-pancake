package model.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BoardDTO;

public class BoardDAO {

	private SqlSession session = OracleConnection.getSqlSession();
	
	public List<BoardDTO> selectPage(Map<String, Object> map) {
		List<BoardDTO> data = session.selectList("boardMapper.selectPage", map);
		return data;
	}
	
	public int totalRowCount() {
		int count = session.selectOne("boardMapper.totalRowCount");
		return count;
	}
	
	public BoardDTO selectData(BoardDTO dto) {
		BoardDTO data = session.selectOne("boardMapper.selectData", dto);
		return data;
	}
	
	public int updateViewCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateViewCnt", dto);
		return count;
	}
	
	public int selectNextSeq() {
		int seq = session.selectOne("boardMapper.selectNextSeq");
		return seq;
	}
	
	public int insert(BoardDTO dto) {
		int count = session.insert("boardMapper.insert", dto);
		return count;
	}
	
	public int update(BoardDTO dto) {
		int count = session.update("boardMapper.update", dto);
		return count;
	}
	
	public int delete(BoardDTO dto) {
		int count = session.delete("boardMapper.delete", dto);
		return count;
	}
	
	public int delete(List<Integer> arrId) {
		int count = session.delete("boardMapper.checkedDelete", arrId);
		return count;
	}
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}

}
