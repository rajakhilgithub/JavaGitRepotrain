package net.opentrends.sendmail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendmail
 */
@WebServlet("/sendmailpath")
public class sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String to="akhilraj@opentrends.net";
		String from="mailer@opentrends.net";
		String host="192.168.2.5";
		Properties p=System.getProperties();
		p.setProperty("mail.smtp.host", host);
		Session s=Session.getDefaultInstance(p);
		try {
			MimeMessage mess=new MimeMessage(s);
			mess.setFrom(new InternetAddress(from));
			mess.setRecipient(RecipientType.TO,new InternetAddress(to));
			mess.setSubject("Test Mail");
			System.out.println("Actual Message");
			mess.setText("This is a test message for mail sending");
			Transport.send(mess);
			System.out.println("Message sent succesfully");
		}
		catch(MessagingException m){
			m.printStackTrace();
		}
	}

}
