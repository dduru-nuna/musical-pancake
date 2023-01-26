package model.dao;

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
