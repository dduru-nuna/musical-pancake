package controller.ajax;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.dto.BoardImageDTO;

@WebServlet("/ajax/imageUpload")
@MultipartConfig
public class ImageUploadController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part image = req.getPart("imageUpload");  //imageUpload는 blob 값을 가지는데 이는 파일이라 part 객체로 받아옴
		String location = req.getParameter("location");
		
		ServletContext sc = req.getServletContext();
		
		int maxFileSize = Integer.parseInt(sc.getInitParameter("maxFileSize"));
		String permitFileType = sc.getInitParameter("permitFileType");
		String[] permitFileExt = sc.getInitParameter("permitFileExt").split(",");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String path = "/static/img/"+ location + "/" + df.format(new Date()) + "/";
		String realPath = sc.getRealPath(path);
		String uuid = UUID.randomUUID().toString();
		
		File f = new File(realPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		if(image.getSize() <= maxFileSize) {
			if(image.getContentType().startsWith(permitFileType)) {
				if(image.getContentType().endsWith(permitFileExt[0]) ||
						image.getContentType().endsWith(permitFileExt[1])) {
					image.write(String.join("/", realPath, uuid));					
				}
			}
		}
		
		JsonFactory jf = new JsonFactory();
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createGenerator(sw);
		
		jg.writeStartObject();		
		jg.writeStringField("imageUrl", req.getContextPath() + path+uuid);
		jg.writeEndObject();
		jg.close();
		
		resp.getWriter().print(sw.toString());
		resp.getWriter().flush();

	}
}
