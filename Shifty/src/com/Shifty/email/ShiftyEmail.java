/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShiftyMailService;

/**
 *JAVA project Methodology of Programming 2
 * Shifty Logger Mail Service 
 * @author Beltran Castro Carlos Ricardo
 * NeptunCode: VY6V8S
 */

// Main class to send Email
public class ShiftyEmail {
    
    static String toEmail = "mailloggershifty@gmail.com"; // Tatribute for the recepient email
    static boolean late = true; // atribute in case late mail has to be send 
    static boolean absent= true; // atribute in case absent mail has to be send 
    
    //Metjhod to deliver email to recepient 
    public static void main(String[] args) throws Exception {
        
        if (late = true)  // codition to be applied if late is true
            ShiftyLateMail.sendMail(toEmail);
        
        if (absent = true) // codition to be applied if absent is true
            ShiftyAbsentMail.sendMail(toEmail);
    }
    
}
