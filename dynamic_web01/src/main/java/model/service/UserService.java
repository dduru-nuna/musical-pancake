package model.service;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserService {

	public int add(UserDTO dto) {
		UserDAO dao = new UserDAO();
		
		UserDTO data = dao.selectUser(dto);
		if(data == null) {			
			int count = dao.insert(dto);
			if(count == 1) {
				dao.commit(); dao.close();
				return 1;
			}
			dao.rollback(); dao.close();
			return 0;
		}
		return -1;
	}

	public UserDTO login(UserDTO dto) {
		UserDAO dao = new UserDAO();
		
		UserDTO data = dao.selectUser(dto);
		if(data == null) {
			dao.close();
			return null;
		} else {
			if(data.getPassword().equals(dto.getPassword())) {
				dao.close();
				return data; //패스워드 맞게 입력하면 userId, password, email 정보 반환
			}
		}
		dao.close();
		return null;
	}

	public boolean update(UserDTO userData, UserDTO dto, String password) {
		UserDAO dao = new UserDAO();
		UserDTO data = dao.selectUser(userData);  //로그인 사용자 정보가 담긴 userData를 selectUser 로 조회한 결과를 data 에 저장
		
		if(data == null) {
			dao.close();
			return false;
		} else {
			if(data.getPassword().equals(password)) {  //로그인 사용자 비밀번호와 입력한 현재 비밀번호 데이터가 같은 경우(개인정보수정을 하려면 현재 비밀번호를 맞게 입력해야 가능하게 함)
				dto.setUserId(data.getUserId());  //myinfo 서블릿에서 dto에 변경 패스워드와 변경 이메일만 설정했는데 여기서 로그인사용자의 id로 userId 설정
				if(dto.getPassword().isEmpty()) {  //혹시나 만약 변경 패스워드 입력 안한 경우 기존 패스워드 유지하게 함
					dto.setPassword(data.getPassword());
				}
				int count = dao.update(dto); //로그인 사용자 아이디, 변경할 패스워드, 변경할 이메일 값 가진 dto 가지고 update 구문 실행했을 때 제대로 반영되면 1(행 한개) 반환됨
				if(count == 1) {
					dao.commit(); dao.close();
					return true;
				}
			}
		}
		dao.rollback();
		dao.close();
		return false;
	}

}
