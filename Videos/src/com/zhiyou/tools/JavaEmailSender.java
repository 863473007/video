package com.zhiyou.tools;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��21�� ����9:37:50
 * ��˵��
 */
public class JavaEmailSender {



	    public static void sendEmail(String toEmailAddress,String emailTitle,String emailContent)throws Exception{
	        Properties props = new Properties();

	        // ����debug����
	        props.setProperty("mail.debug", "true");
	        // ���ͷ�������Ҫ�����֤
	        props.setProperty("mail.smtp.auth", "true");
	        // �����ʼ�������������
	        props.setProperty("mail.host", "smtp.qq.com");
	        // �����ʼ�Э������
	        props.setProperty("mail.transport.protocol", "smtp");

	        /**SSL��֤��ע����Ѷ�����ǻ���SSL���ܵģ�������Ҫ�����ſ���ʹ��**/
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.ssl.socketFactory", sf);

	        //�����Ự
	        Session session = Session.getInstance(props);

	        //���͵���Ϣ�����ڹ۲���ģʽ������Ƶ�
	        Message msg = new MimeMessage(session);
	        msg.setSubject(emailTitle);
	        //ʹ��StringBuilder����ΪStringBuilder�����ٶȻ��String�죬�����̰߳�ȫ��Ҳ����
	        StringBuilder builder = new StringBuilder();
	        builder.append("\n"+emailContent);
	        builder.append("\nʱ�� " + new Date());
	        msg.setText(builder.toString());
	        msg.setFrom(new InternetAddress("838700991@qq.com"));

	        Transport transport = session.getTransport();
	        transport.connect("smtp.qq.com", "838700991@qq.com", "uoobqpyfsyhpbbgg");
	        //������Ϣ
	        transport.sendMessage(msg, new Address[] { new InternetAddress(toEmailAddress) });
	        transport.close();
	    }
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 JavaEmailSender.sendEmail("18137884406@163.com", "���", "������֤����xxxx");
	}

}
