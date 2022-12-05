package kr.co.controller;

import java.util.List;

import kr.co.dao.AccountDAO;
import kr.co.view.AccountView;
import kr.co.vo.AccountVO;

public class AccountController {

	public void getAccountRequestList() {
		AccountDAO dao = new AccountDAO();
		AccountView view = new AccountView();
		
		List<AccountVO> data = dao.selectAccountRequest();
		view.show(data);
	}

	public void setAccountRequest(String nickname, String email) {
		AccountDAO dao = new AccountDAO();
		AccountVO vo = new AccountVO();
		vo.setNickname(nickname);
		vo.setEmail(email);
		
		AccountView view = new AccountView();
		boolean isDuplication = dao.duplicationCheck(vo);
		if(isDuplication) {
			view.message("닉네임 또는 이메일이 중복되었습니다. 다시 입력하세요.");
		} else {
			boolean result = dao.insertAccountRequest(vo);
			view.show(result);
		}
		
	}

	public void getAccountList() {
		AccountDAO dao = new AccountDAO();
		AccountView view = new AccountView();
		
		List<AccountVO> listData = dao.selectAccountList();
		
		view.show(listData);
	}

	public void acceptAccountRequest(int[] idArr) {
		AccountDAO dao = new AccountDAO();
		AccountView view = new AccountView();
		
		for(int id: idArr) {
			dao.updateAccountRequest(id);
		}
		
		view.message("가입 승인 처리가 완료되었습니다.");
	}

	public AccountVO login(String nickname, String password) {
		AccountDAO dao = new AccountDAO();
		
		AccountVO data = new AccountVO();
		data.setNickname(nickname);
		data.setPassword(password);
		
		AccountVO account = dao.selectAccount(data);
		AccountView view = new AccountView();
		if(account == null) {
			view.message("로그인 실패 : 정보를 다시 확인하세요");
			return null;
		} else {
			view.message("로그인 성공!");
			return account;
		}
	}

	public AccountVO logout(AccountVO user) {
		AccountDAO dao = new AccountDAO();
		AccountView view = new AccountView();
		
		dao.insertAccountLogoutLog(user);
		view.message("로그아웃 되었습니다.");
		return null;
	}

}
