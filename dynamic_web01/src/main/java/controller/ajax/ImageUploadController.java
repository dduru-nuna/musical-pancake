package controller.ajax;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/ajax/imageUpload")
@MultipartConfig
public class ImageUploadController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part image = req.getPart("imageUpload");
		String location = req.getParameter("location");
		
		System.out.println(location);
		System.out.println(image.getSubmittedFileName());
		
		resp.getWriter().print("{\"imageUrl\": \"/static/img/board/test.jpeg\"}");
		resp.getWriter().flush();
	}
}
