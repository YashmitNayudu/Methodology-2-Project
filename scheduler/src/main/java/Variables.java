
public class Variables {
    private Integer loginTime = 900;
    private Integer shiftStart = 800;
    private String userName = "Carlos";
    private String userEmail = "Carlos@late.com";
    private Integer late;// 0- Flase 1- True , ill use it to keep track of if the user is late or not
    
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
    this.late = newLate;}
    
}
