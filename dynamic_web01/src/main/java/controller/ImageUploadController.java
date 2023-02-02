package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.dto.UserDTO;
import model.service.UserService;

@WebServlet("/myinfo/uploadImage")
@MultipartConfig(
		location = "D:/imageTemp", //절대경로만 가능. 서버에 배포하거나 프로젝트마다 변경하기 번거로우니 여기엔 공통경로를 지정해 임시로 저장될 수 있게끔만 하도록 한다. 실제 경로는 코드에 직접 넣기
	//	maxFileSize = 1024 * 1024 * 10,
	//	maxRequestSize = 1024 * 1024 * 50,
		fileSizeThreshold = 1024
)
public class ImageUploadController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath = "";
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		Part imageFile = req.getPart("imageFile");
		int maxFileSize = Integer.parseInt(req.getServletContext().getInitParameter("maxFileSize")); //web.xml 에 전역 설정 값 가져오기
		String permitFileType = req.getServletContext().getInitParameter("permitFileType");
		String[] permitFileExt = req.getServletContext().getInitParameter("permitFileExt").split(",");
		
		if(imageFile.getSize() <= maxFileSize) {
			if(imageFile.getContentType().startsWith(permitFileType)) {
				if(imageFile.getContentType().endsWith(permitFileExt[0]) ||
						imageFile.getContentType().endsWith(permitFileExt[1])) {
					System.out.println("파일명: " + imageFile.getSubmittedFileName());
					System.out.println("파일크기: " + imageFile.getSize());
					System.out.println("파일종류: " + imageFile.getContentType());
					
					//webapp 안의 경로 작성
					String path = req.getServletContext().getRealPath("/static/img/profile"); //getRealPath() 로 실제 프로젝트 경로를 찾을 수 있다. (/static/img/profile 이 배포된 실제 서버 위치)
					
					imageFile.write(path + "/" + imageFile.getSubmittedFileName()); //write로 이미지 저장(기본 저장 위치는 location 이나 따로 절대경로를 작성하면 거기에 저장됨)
					//getContentType() 을 활용하여 원치않는 파일종류는 write 작업에서 제외할 수도 있다. delete()로 삭제도 가능
					
					//업로드된 파일은 서버의 하드디스크에 저장되도록 따로 저장 위치 설정해야함. DB에는 경로만 작성됨(파일 자체x)
					user.setpImg("/static/img/profile/" + imageFile.getSubmittedFileName());
					UserService service = new UserService();
					service.uploadImage(user);
					
				    //이미지 업로드 하여 전송 눌렀을때 로그아웃 시키기
					resp.sendRedirect(req.getContextPath() + "/logout");
					return;
				} else {
					req.setAttribute("errorType", "fileExtError");
					viewPath = "/WEB-INF/view/error/imageUploadError.jsp";
				}
			} else {
				req.setAttribute("errorType", "fileTypeError");
				viewPath = "/WEB-INF/view/error/imageUploadError.jsp";
			}
		} else {
			req.setAttribute("errorType", "fileSizeError");
			viewPath = "/WEB-INF/view/error/imageUploadError.jsp";
		}
		req.getRequestDispatcher(viewPath).forward(req, resp);
		
	}
}
