
public class Employee {
    //Reading the needed variables
    Variables object = new Variables();
    
    Integer myLoginTime = object.getLoginTime();
    Integer myShiftStartTime = object.getShiftStart();
    String myUserName = object.getUserName();
    String myUserEmail = object.getUserEmail();
    
    
    public void ifLate(){
        //This compares login time with shift start and determines if the employee is late or not
        //If they are late the late variable is set to 1, if not late the variable is set to 0
        if(myLoginTime > myShiftStartTime){
            object.setLate(1);
            System.out.println(object.getLate());}
        else{ 
            object.setLate(0);
            System.out.println(object.getLate());}
        
        
        System.out.println(object.getLate());}
        
    
    public void email(){
        //If myLate is 1, the email and the name of the employee will be  sent to the emailing service.
        if(object.getLate() != 0){
            String lateEmployee = String.format("The late employee is %1$s , their email address is %2$s", myUserName,myUserEmail);
            System.out.println(lateEmployee);
        }
    
    }

}
