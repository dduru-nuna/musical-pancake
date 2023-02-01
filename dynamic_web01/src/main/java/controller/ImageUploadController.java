package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/myinfo/uploadImage")
@MultipartConfig(
		location = "D:/imageTemp",
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5,
		fileSizeThreshold = 1024
)
public class ImageUploadController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part imageFile = req.getPart("imageFile");
		System.out.println(imageFile.getSubmittedFileName());
	}
}
