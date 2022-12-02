package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.main.OracleConnection;
import kr.co.vo.AccountVO;

public class AccountDAO {
	
	private SqlSession sess = OracleConnection.getSqlSession();
	
	public List<AccountVO> selectAccountRequest() {
		List<AccountVO> resultSet = sess.selectList("test.reqAccount");
		return resultSet;                         //namespace.id
	}

}
