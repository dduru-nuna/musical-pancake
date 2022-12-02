package kr.co.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.vo.AccountVO;

public class OracleConnection {
	
	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		//mybatis 사용하여 mybatis-config.xml : 접속정보, 구성정보
		//               mapper.xml : SQL 구문               만들어 놓고 사용
		
		try(InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml")){
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sess = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}


}
