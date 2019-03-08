package cv64.mail;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
//import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * <code>SendFile</code> sets up a Multitype MIME Mail Message.
 *
 * There are 5 methods required to be called initially.
 *
 * 1) init 		initializes mail properties, sets up the default Session
 *			and the MIME message object, e.g. init("mail.earthlink.net", true);
 * 2) setFrom		sets the from string in the mail message,
 *			e.g. setFrom("estey@cv64.com");
 * 3) setTo		sets the to string in the mail message,
 * 			e.g. setTo("estey@cv64.com");
 * 4) setSubjectText	sets the subject text in the mail message,
 *			e.g. setSubjectText("some subject text");
 * 5) sendEnclosure    sets up body text and encloses a file and sends the
 *			contents as a MIME multipart object to the receipient,
 *			e.g. sendEnclosure("body text", "filename");
 */
public class SendFile {

	public SendFile() {}

	/**
	 * Method init initializes mail properties, sets up the default Session
	 * and the MIME message object
	 *
	 * @param mailHost sets the SMTP mailing system that is providing
	 * the SMTP deamon, e.g. mail.earthlink.net
	 *
	 * @param debug true - if show debugging information
	 *		false - no debugging information
	 */
	public void init(String mailHost, boolean debug) {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", mailHost);

		session_ = Session.getDefaultInstance(props, null);
		session_.setDebug(debug);
		message_ = new MimeMessage(session_);
	}

	/**
	 * Method send enclosure sets up body text and encloses a file and
	 * sends the contents as a MIME multipart object to the receipient
	 *
	 * @param bodyText text that is writting to the body of the mail message
	 *
	 * @param filename name of file to send to the to email address,
	 * e.g. somefile.txt
	 *
	 * @exception Exception mail body text or filename invalid
	 */
	public void sendEnclosure(String bodyText, String fileName) {

		try {
			// create the MIME body (body text and message) and
			// multi part objects
			MimeBodyPart mbpText = new MimeBodyPart();
			MimeBodyPart mbpFile = new MimeBodyPart();
			Multipart multiPart = new MimeMultipart();

			// attach text to the message and multipart object
			mbpText.setText(bodyText);
			multiPart.addBodyPart(mbpText);

			// if fileName exists then attach to message
			if (fileName != null) {
				// attach a file to the message and multipart object
				FileDataSource fds = new FileDataSource(fileName);
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(fds.getName());
				multiPart.addBodyPart(mbpFile);
			}

			// add the Multipart to the message
			message_.setContent(multiPart);

			// set the Date: header
			message_.setSentDate(new Date());

			// send the message
			Transport.send(message_);

		} catch (Exception exception) {
			System.err.println("SendFile.sendEnclosure(" + bodyText +
			    ", " + fileName + ")");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	/**
	 * Mutator method that sets the from string in the mail message
	 *
	 * @param from email address coming from, e.g. estey@cv64.com
	 *
	 * @exception Exception Internet address coming from is invalid
	 */
	public void setFrom(String from) {

		try {
			if (from == null) {
				from = defaultFrom_;
			}

			message_.setFrom(new InternetAddress(from));

		} catch (Exception exception) {
			System.err.println("SendFile.setFrom(" + from + ")");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	/**
	 * Mutator method that sets the subject text in the mail message
	 *
	 * @param subjectText subject text in the mail message
	 *
	 * @exception Exception subject text is invalid
	 */
	public void setSubjectText(String subjectText) {

		try {
			message_.setSubject(subjectText);

		} catch (Exception exception) {
			System.err.println("SendFile.setSubjectText(" + subjectText + ")");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	/**
	 * Mutator method that sets the to string in the mail message
	 *
	 * @param to email address going to, e.g. estey@cv64.com
	 *
	 * @exception Exception Internet address being sent to is invalid
	 */
	public void setTo(String[] to) {

		try {
			InternetAddress[] address = new InternetAddress[to.length];

			for (int i=0; i < to.length; i++) {
				address[i] = new InternetAddress(to[i]);
			}

			message_.setRecipients(Message.RecipientType.TO, address);

		} catch (Exception exception) {
			System.err.println("SendFile.setTo(" + to + ")");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	/**
	 * main method - sets up debugging capability
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		// array of to addresses
		String[] to = new String[3];
		to[0] = "info@cv64.com";
		to[1] = "sales@cv64.com";

		SendFile sendFile = new SendFile();
		// SMTP Provider, debugging
		sendFile.init("mail.earthlink.net", true);
		// From address
		sendFile.setFrom("esteyr@earthlink.net");
		// To addresses
		sendFile.setTo(to);
		// Subject Line
		sendFile.setSubjectText("Subject Text");
		// File Enclosure
		sendFile.sendEnclosure("Enclosure Text", "SendFile.java");
	}

	/** A mail session that collects properties and defaults used by the mail API's */
	private Session session_ = null;
	/** Represents a MIME style email message */
	private MimeMessage message_ = null;
	/** Default from is client enters an invalid email address */
	private static final String defaultFrom_ = "esteyr@earthlink.net";
}
