package filter;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")  // 모든 URL 주소에 이 필터가 동작하도록 할 때 /*
public class LoggingFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;  //ServletRequest -> HttpServletRequest 다운캐스팅 필요
		HttpServletResponse response = (HttpServletResponse)resp;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a KK:mm:ss.SSS"); //KK -> 01~12 로 일의 자리를 0 붙여서 표현
		
		String path = request.getRequestURI();
		String method = request.getMethod();  // request 객체에서 get방식, post방식 등의 정보 가져와서 method에 저장
		String query = request.getQueryString();  //request객체의 uri 에서 ? 뒤의 parameter 정보 가져와서 query에 저장
		
		System.out.printf("[%s] - %s: %s\n", df.format(new Date()), method, path);
		if(query != null) {
			System.out.println("?" + query); 
		}
		
		chain.doFilter(req, resp); //다음 필터 호출. 계속 연계하다가 마지막에 있는 필터는 최종적으로 서블릿으로 연계한다.
		
		//response객체에서 응답된 http 상태 코드정보 code에 저장. ex.404:잘못된 요청(페이지없음), 200:정상, 302:리다이렉트, 500:서버오류
		int code = response.getStatus(); 
		String redirect = response.getHeader("Location");
		
		System.out.printf("[%s] - %s: ", df.format(new Date()), code);
	
		switch(code / 100) {
		case 2:
			System.out.print("정상"); 
			break;
		case 3:
			System.out.printf("리다이렉트(%s)", redirect);
			break;
		case 4:
			System.out.print("요청 오류");
			break;
		case 5:
			System.out.print("서버 오류");
			break;
		}
		System.out.println();
	}
}
