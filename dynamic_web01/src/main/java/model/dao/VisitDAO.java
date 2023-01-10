package model.dao;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;

public class VisitDAO {

	public int insert(String context) {
		SqlSession session = OracleConnection.getSqlSession();
		String res = session.selectOne("visitMapper.connectTest");
		System.out.println(res);
		return 0;
	}

}
