package database.connect;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleConnection {
	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		//마이바티스가 세션 객체를 만들어주면 우리는 가지고만 오는것~
		try(InputStream is = Resources.getResourceAsStream("resources/mybatis-config.xml")){
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sess = factory.openSession(false); //자동커밋x
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
}
