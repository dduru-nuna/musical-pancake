package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/bookmark", "/myinfo", "/bookmark/*", "/board/add", "/board/update", "/board/delete", "/board/clickGood", "/board/clickBad", "/ajax/recommend"})
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		if((boolean)session.getAttribute("login")) {
			chain.doFilter(req, resp);
		} else {
			//비동기는 sendRedirect 로 전환되지 않음. 따라서 uri에 ajax(비동기 처리는 ajax를 항상 사용할 것이다) 포함되면 getWriter로 응답 주소 직접 설정
			if(request.getRequestURI().contains("ajax")) {
				//getWriter() -> PrintWriter 객체 가져오기
				response.getWriter().print("{\"redirect\": \"" + request.getContextPath() + "/login\"}");
				response.getWriter().flush();
			} else {
				response.sendRedirect(request.getContextPath() + "/login");		
			}
		}

	}
}
