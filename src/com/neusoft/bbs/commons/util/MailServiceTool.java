package com.neusoft.bbs.commons.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 我的邮件工具
 * @author yangz
 *
 */
public class MailServiceTool {
	/**
	 * 简单的发送邮件
	 * @param toAddr 发送地址
	 * @param subject  主题
	 * @param content  正文
	 * @throws MessagingException
	 */
	public static void sendMail(String toAddr,String subject,String content) 
			throws MessagingException{

		//1. 得到session
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("yangzaiqing163@163.com", "520025ty");
			}
		};
		Session session = Session.getInstance(props, auth);
		
		//2. 创建MimeMessage
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("yangzaiqing163@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, toAddr);//设置收件人
		
		msg.setSubject(subject);
		msg.setContent(content, "text/html;charset=utf-8");
		
		//发送
		Transport.send(msg);
	}
}
