
package ShiftyMailService;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *JAVA project Methodology of Programming 2
 * Shifty Logger Mail Service 
 * @author Beltran Castro Carlos Ricardo
 * NeptunCode: VY6V8S
 */


public class ShiftyLateMail { //This is the class where the logic to send an email is written

    static String shiftyEmailAccount = "shiftymailnotification@gmail.com"; //requires valid gmail id
    static String shiftyEmailPassword = "***************"; // correct password for gmail id
    
    //This is the method where we set up the properties for the email to be send
    public static void sendMail(String recepient) throws Exception { 
        System.out.println("Preparing to send Shifty email");
        Properties properties = new Properties(); 
        /* The properties object contains key and value pair both as a string.
        The java.util.Properties class is the subclass of Hashtable.
        It can be used to get property value based on the property key. 
        The Properties class provides methods to get data from the properties 
        file and store data into the properties file. Moreover, it can be used to get the properties of a system.
        */
        properties.put("mail.smtp.auth","true"); //enable authentication
        properties.put("mail.smtp.starttls.enable","true"); //enable STARTTLS
        properties.put("mail.smtp.host","smtp.gmail.com"); //SMTP Host
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //SMTP trust Host
        properties.put("mail.smtp.port","587"); //TLS Port
        
        //create Authenticator object to pass in Session.getInstance argument
        Session session;
        session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(shiftyEmailAccount, shiftyEmailPassword);
            }
        });
        
        Message message = prepareMessage(session, shiftyEmailAccount, recepient);
        
         // Send message
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
     // Create the message body part
    private static Message prepareMessage(Session session, String shiftyEmailAccount, String recepient) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(shiftyEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Shifty Email Logger Message");
            message.setText("\nThis is a Shifty Email \n\n"
                    + "You have recieved this message becasue you are late! \n"
                    + "You better be on time or you  will be in trouble. \n\n"
                    + "Thank you for your attention.\n\n"
                    + "GET BACK TO WORK!");
            
            return message;
        } catch (MessagingException ex) {   //exeption for email to get into email
            Logger.getLogger(ShiftyLateMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    private ShiftyLateMail() {
    }

}
