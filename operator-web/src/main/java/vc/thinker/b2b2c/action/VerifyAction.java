package vc.thinker.b2b2c.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: VerifyAction.java
 * </p>
 * 
 * <p>
 * Description: 系统验证控制器，用来管理系统验证码生成、用户名验证、邮箱验证等各类验证请求
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-16
 * 
 * @version 1.0.1
 */
@Controller
public class VerifyAction {

	/**
	 * 验证码ajax验证方法
	 * 
	 * @param response
	 */
	@RequestMapping("/verify_code.htm")
	public void validate_code(HttpServletRequest request, HttpServletResponse response, String code,
			String code_name) {
		HttpSession session = request.getSession();
		String verify_code = "";
		if (CommUtil.null2String(code_name).equals("")) {
			verify_code = (String) session.getAttribute("verify_code");
		} else {
			verify_code = (String) session.getAttribute(code_name);
		}
		boolean ret = true;
		if (verify_code != null && !verify_code.equals("")) {
			if (!CommUtil.null2String(code.toUpperCase()).equals(verify_code)) {
				ret = false;
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证码生成
	 * 
	 * @param response
	 * @param mobile
	 * @throws IOException
	 */
	@RequestMapping("/verify.htm")
	public void verify(HttpServletRequest request, HttpServletResponse response, String name, String w,
			String h) throws IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession(false);
		// 在内存中创建图象
		int width = 73;
		int height = 27;
		if (!CommUtil.null2String(w).equals("")) {
			width = CommUtil.null2Int(w);
		}
		if (!CommUtil.null2String(h).equals("")) {
			height = CommUtil.null2Int(h);
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 24));

		// 画边框
		g.setColor(new Color(80, 80, 80));
		g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 255; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = CommUtil.randomInt(1).toUpperCase();
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 14 * i + 6, 24);
		}

		// 将认证码存入SESSION
		if (CommUtil.null2String(name).equals("")) {
			session.setAttribute("verify_code", sRand);
		} else {
			session.setAttribute(name, sRand);
		}
		// 图象生效
		g.dispose();
		ServletOutputStream responseOutputStream = response.getOutputStream();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", responseOutputStream);

		// 以下关闭输入流！
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
