package com.neusoft.bbs.commons.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证码创建
 * @author Zaiqing Yang
 *
 */
public class ImageCreator {
	/**
	 * 创建验证码
	 * @param response 
	 * @return
	 * @throws IOException
	 */
	public static String getImage(HttpServletResponse response) throws IOException{
		String vtext = "";
		//图片大小
		int width = 160;
		int height = 40;
		//图片缓冲区
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//画笔
//		Graphics g = image.getGraphics();
		Graphics2D g = (Graphics2D) image.getGraphics();//可用于旋转
		g.setColor(Color.WHITE);//白色画笔
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, width-1, height-1);//矩形，即边框
		//数据准备
		String data = "0123456789qwertyuiopasdfghjklzxcvbnm";
		//字形准备
		Font font[] = {new Font("宋体",Font.ITALIC,30),
				new Font("楷体",Font.ITALIC,30),
				new Font("行楷",Font.ITALIC,30)};
		Color color[] = {Color.BLUE,Color.RED,Color.BLACK};
		//创建获取随机数据
		Random r = new Random();
		for(int i= 0;i<4;i++){//循环每次取一个字
			int cindex = r.nextInt(data.length());
			int sindex = r.nextInt(font.length);
			char ch = data.charAt(cindex);
			//设置样式
			g.setColor(color[sindex]);
			g.setFont(font[sindex]);
			//在写字之前将画笔旋转:单位弧度
			int k = r.nextInt(90);//模拟角度
			double huDeg = (k-60)*Math.PI/180;//转成弧度
			g.rotate(huDeg, 10+i*40,30);//g.rotate(theta, x, y)度数，起始位置
			//写drawString(str, x, y);xy为坐标，从左上角00开始。
			g.drawString(ch+"", 10+i*40,30);
			//记录文字
			vtext += (ch+"");
			//划线
			//记得恢复旋转
			g.rotate(-huDeg, 10+i*40,30);
			g.drawLine(r.nextInt(150), r.nextInt(150),r.nextInt(150), r.nextInt(150));
		}
		//输出验证码的图片并返回文字
		ImageIO.write(image, "jpeg", response.getOutputStream());
		return vtext;
	}
}
