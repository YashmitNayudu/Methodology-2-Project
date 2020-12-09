
class Variables {
    private Integer loginTime = 880;
    private Integer shiftStart = 800;
    private String userName = "Carlos";
    private String userEmail = "Carlos@late.com";
    private Integer late = 0;// 0- Flase 1- True , ill use it to keep track of if the user is late or not
    private Integer absent = 0; //This will track if the worked is absent or not, 0- here 1- absent
    private Integer minsLate = 0;
    
    //Getters
    public Integer getLoginTime(){
        return loginTime;}
    public Integer getShiftStart(){
        return shiftStart;}
    public Integer getLate(){
        return late;}
    public Integer getAbsent(){
    return absent;}
    public Integer getMinsLate(){
    return minsLate;}
    
    public String getUserName(){
        return userName;}
    public String getUserEmail(){
        return userEmail;}
    //Setters
    public void setLate(Integer newLate){
    this.late = newLate;}
    
    public void setAbsent(Integer newAbsent){
        this.absent = newAbsent; }
    
    public void setMinsLate(Integer newMinsLate){
    this.minsLate = newMinsLate;}
    }

/*cheduler logic lives here*/
public class scheduler {
   /*Reading the needed variables*/
    Variables object = new Variables();
    
    Integer myLoginTime = object.getLoginTime();
    Integer myShiftStartTime = object.getShiftStart();
    String myUserName = object.getUserName();
    String myUserEmail = object.getUserEmail();
   
    
    public void ifLate(){
        /*his compares login time with shift start and determines if the employee is late or not
        /If they are late the late variable is set to 1, if not late the variable is set to 0*/
        if(myLoginTime > myShiftStartTime){
            object.setLate(1);
            object.setAbsent(0);
            System.out.println("The employee: "+myUserName+" is late." );
        
        Integer minutsLate = myLoginTime- myShiftStartTime;
        object.setMinsLate(minutsLate);

        }
        else{ 
            object.setLate(0);
            object.setAbsent(0);
            System.out.println("The employee: "+myUserName+" is not late." );}
    }
            
    
    public void email(){
   /*  If myLate is 1, the email and the name of the employee will be  sent to the emailing service.*/
        if(object.getLate() != 0){
            String lateEmployee = String.format("Name of the late employee: %1$s , their email address is %2$s. They were %3$s late", myUserName,myUserEmail,object.getMinsLate());
            System.out.println(lateEmployee);
        }else{
            String employeeNotLate = String.format("The employee: %1s is not late.This is coming from email",myUserName);
            System.out.println(employeeNotLate);}}
    
       /*This checks if the employee is absent or not*/
       public void ifAbsent(){
           /*If the employee logs in theyll have a shift start time, if they dont log in at all their logintime will be null*/
           if(object.getAbsent() != null ){
               
               String notAbsent = String.format("The employee: %1$s is not absent.",myUserName);
               System.out.println(notAbsent);
           } 
       
       }
//Call this method in main. 
public  void control(){
        ifLate();
        email();
        ifAbsent();}
 }//The end of scheduler
