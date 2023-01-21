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

	public boolean insertAccountRequest(AccountVO vo) {
		int result = sess.insert("test.insertReqAccount", vo);
		if(result == 1) {  //insert 하면 반영된 행 수 반환. 반환된게 있으면 insert 성공했다는 것
			sess.commit(); //수동커밋으로 되어있어서 커밋을 따로 시켜줘야 insert 한 데이터를 볼 수 있다.
			return true;
		} else {
			sess.rollback();
			return false;
		}
	}

	public boolean duplicationCheck(AccountVO vo) {
		int result = sess.selectOne("test.dupReqAccountNickname", vo);
		if(result == 1) {
			return true;
		}
		result = sess.selectOne("test.dupReqAccountEmail", vo);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public List<AccountVO> selectAccountList() {
		List<AccountVO> result = sess.selectList("test.selectAccountList");
		return result;
	}

	public void updateAccountRequest(int id) {
		int result = sess.update("test.updateAccountRequest", id);
		if(result == 1) {
			AccountVO account = sess.selectOne("test.selectAccountRequestId", id);
			sess.insert("test.insertAccount", account);
			if(result == 1) {
				sess.commit();
			} else {
				sess.rollback();
			}
		}
		sess.rollback();
;	}

	public AccountVO selectAccount(AccountVO data) {
		AccountVO result = sess.selectOne("test.selectAccount", data);
		
		if(result != null) {
			int cnt = sess.update("test.updateAccountLoginDate", result);
			if(cnt == 1) {
				cnt = sess.insert("test.insertAccountLogLoginDate", result);
				if(cnt == 1) {
					sess.commit();
				} else {
					sess.rollback();
				}
			} else {
				sess.rollback();
			}
		}
		return result;
	}

	public void insertAccountLogoutLog(AccountVO user) {
		int result = sess.insert("test.insertAccountLogoutLog", user);
		if(result == 1) {
			sess.commit();
		} else {
			sess.rollback();
		}
	}
   
	//내 풀이. 수정 필요
	public AccountVO selectPassword(AccountVO data) {
		AccountVO result = sess.selectOne("test.selectPassword", data);
		
		if(result != null) {
			int cnt = sess.update("test.updateChangePassword", result);
			if(cnt == 1) {
				sess.commit();
			} else {
				sess.rollback();
			}
		}
		return result;
	}


}
