package main.service;

import java.util.List;

import board.dto.BoardDTO;

/**
 * 메인화면에서 여러 서비스를 제공하기 위해 필요한 비지니스 로직을 구현
 */
public class MainService {	
	/**
	 * 게시글에 작성된 최근 글 목록을 제공하기 위한 기능
	 * @param size : 최근 글 목록 수
	 * @return
	 */
	public List<BoardDTO> getLatestBoard(int size) {
		return null;
	}
	
	/**
	 * 게시글에 작성된 글 중 조회수가 가장 많은 글 목록을 제공하기 위한 기능<br>
	 * 최근 1주일 이내에 작성한 글 중 조회수가 많은 글을 조회한다.
	 * @param size : 조회수가 많은 게시글의 수
	 * @return
	 */
	public List<BoardDTO> getBestBoard(int size) {
		return null;
	}
	
}