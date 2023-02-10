package main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dto.BoardDTO;
import database.connect.OracleConnection;

public class MainDAO {

	private SqlSession session = OracleConnection.getSqlSession();
	/**
	 * 최신글을 조회하기 위한 맵퍼와 연결된 메서드
	 * @param size : 최근 글 목록 수
	 * @return
	 */
	public List<BoardDTO> selectLatestBoard() { //글의 수가 고정이 아닌 가변적으로 변하는 경우 생각
		List<BoardDTO> data = session.selectList("board.selectLatest");
		return null;
	}
	/**
	 * 조회수가 가장 많은 글을 조회하기 위한 맵퍼와 연결된 메서드
	 * @param size : 조회수가 가장 많은 게시글의 수
	 * @return
	 */
	public List<BoardDTO> selectBestBoard() {
		List<BoardDTO> data = session.selectList("board.selectBest");
		return null;
	}
}
