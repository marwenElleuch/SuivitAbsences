package tn.iit.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;

import tn.iit.models.SalleModel;
import tn.iit.models.SeanceModel;

//import org.apache.commons.mail.EmailException;

public class SendEmail {
	public static void sendEmaile(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

//			msg.setFrom(new InternetAddress("elleuchmarwen08@gmail.com", "NoReply-JD"));
//
//			msg.setReplyTo(InternetAddress.parse("elleuchmarwen08@gmail.com", false));

			 msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-JD"));

		     msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
		      
			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendEmail(SeanceModel s) throws EmailException {
		final String fromEmail = "elleuchmarwen08@gmail.com"; // requires valid gmail
														// id
		final String password = "??marwenelleuche93?_GENIINFOMARA93?"; // correct password for gmail id
		final String toEmail = "bboyach@gmail.com"; // can be any email id

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL
																				// Class
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); // SMTP Port

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		sendEmaile(session, toEmail, "seance de ratrapage", s.descrptionSeance());

	}
}