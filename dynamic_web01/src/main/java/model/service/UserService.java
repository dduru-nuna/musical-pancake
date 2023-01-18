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
		UserDTO data = dao.selectUser(userData);
		
		if(data == null) {
			dao.close();
			return false;
		} else {
			if(data.getPassword().equals(password)) {
				dto.setUserId(data.getUserId());
				if(dto.getPassword().isEmpty()) {
					dto.setPassword(data.getPassword());
				}
				int count = dao.update(dto);
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
