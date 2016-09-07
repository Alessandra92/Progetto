package utilita;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMail {

	private final static String USER_NAME = "sanitariaAts";  // GMail user name (just the part before "@gmail.com")
    private final static String PASSWORD = "sanitaria"; // GMail password
    private String RECIPIENT;
    
    public static void sendFromGMail(String[] to, String subject, String body, HttpServletRequest request, HttpServletResponse response) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSWORD);
            }
        });
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            request.setAttribute("inviata", true);
            transport.close();
        }
        catch (AddressException ae) {
        	request.setAttribute("nonInviata", true);
            ae.printStackTrace();
        }
        catch (MessagingException me) {
        	request.setAttribute("nonInviata", true);
            me.printStackTrace();
        }
    
    }

	public String getRECIPIENT() {
		return RECIPIENT;
	}

	public void setRECIPIENT(String string) {
		RECIPIENT = string;
	}
}
