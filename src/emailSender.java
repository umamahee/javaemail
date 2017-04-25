import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * Created by umamaheswari.asokan on 4/5/2017.
 */
public class emailSender {
    public static void main(String args[]) {
        String to = "kavinumamahe@gmail.com"; // sender email
        String from = "kavinumamahe@gmail.com"; // receiver email
        String password ="Kavin@1234";
        //String to = "umamaheswari.asokan@rci.rogers.com"; // sender email
        //String to = "Mahesh.Kutralam@rci.rogers.com"; // sender email
        /*String from = "umamaheswari.asokan@rci.rogers.com"; // receiver email
        String password ="Spring@1234";*/
        String subj= "Test Mail from Java Program";
        String msg="TEST EMAIL";
        //String host = "127.0.0.1"; // mail server host

        /*Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);*/

        //Get properties object for gmail
      /*  Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");*/

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.rci.rogers.com");
        //props.put("mail.smtp.socketFactory.port", "587");
        //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");
        //props.put("mail.smtp.ssl.enable", "true");
       // props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.debug", "true");

        //Session session = Session.getDefaultInstance(properties); // default session
//get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        System.out.println("Authenticating");
                        return new PasswordAuthentication(from,password);
                    }
                });
        System.out.println("Session created");
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            System.out.println("message created");
            message.setFrom(new InternetAddress("umaasokanmku@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subj);
            message.setText(msg);
            System.out.println("message values were added");
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}


    }
}
