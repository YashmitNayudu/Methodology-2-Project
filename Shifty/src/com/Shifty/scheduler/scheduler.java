package com.Shifty.scheduler;

/**
*
* @author TODO add connors name and neptun
*/


class Variables {
    private Integer loginTime = 500;
    private Integer shiftStart = 800;
    private String userName = "Carlos";
    private String userEmail = "Carlos@late.com";
    private Integer late;// 0- False 1- True , ill use it to keep track of if the user is late or not
    
    //Getters
    public Integer getLoginTime(){
        return loginTime;}
    public Integer getShiftStart(){
        return shiftStart;}
    public Integer getLate(){
        return late;}
    
    
    public String getUserName(){
        return userName;}
    public String getUserEmail(){
        return userEmail;}
    //Setters
    public void setLate(Integer newLate){
    this.late = newLate;}}

//Scheduler logic lives here
public class scheduler {
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
        System.out.println("The employee: "+object.getUserName() +" is late." );}
        else{ 
            object.setLate(0);
            System.out.println("The employee: "+object.getUserName() +" is not late." );}
    }
            
    
    public void email(){
        //If myLate is 1, the email and the name of the employee will be  sent to the emailing service.
        if(object.getLate() != 0){
            String lateEmployee = String.format("Name of the late employee: %1$s , their email address is %2$s.", myUserName,myUserEmail);
            System.out.println(lateEmployee);
        }else{
            String employeeNotLate = String.format("The employee: %1s is not late.",myUserName);
            System.out.println(employeeNotLate);}}
    
//Call this method in main. 
public  void control(){
        ifLate();
        email();}
    
 
 }//The end of scheduler
