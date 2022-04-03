package tl.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import tl.VO.CaptchaImageVO;
import tl.util.MyContants;



@RestController
public class CaptchaController {

	@Resource
	DefaultKaptcha captchaProducer;
	
	@GetMapping("/kaptcha")
	public void kaptcha(HttpSession session,HttpServletResponse response) throws IOException {
		
		//固定的寫法,告訴瀏覽器不能緩存
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		response.setHeader("Cache-Control", "post-check=0,pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		
		//生成驗證碼存到session
		String capText=captchaProducer.createText();
		session.setAttribute(MyContants.CAPTCHA_SESSION_KEY, new CaptchaImageVO(capText, 2*60));
		//生成驗證圖片輸出到瀏覽器
		try(ServletOutputStream out = response.getOutputStream()){
			BufferedImage bufferdImage=captchaProducer.createImage(capText);
			ImageIO.write(bufferdImage, "jpg", out);
			out.flush();
		}
	}
	
}
