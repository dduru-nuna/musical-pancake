package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.VisitDTO;

public class VisitDAO {

	SqlSession session = OracleConnection.getSqlSession();
	
	public int insert(VisitDTO dto) {
		int count = session.insert("visitMapper.insert", dto);
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

	public List<VisitDTO> selectAll() {
		List<VisitDTO> data = session.selectList("visitMapper.selectAll");
		return data;
	}
}
