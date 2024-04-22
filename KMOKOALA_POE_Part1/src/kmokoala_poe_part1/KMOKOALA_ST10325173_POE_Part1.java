/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kmokoala_poe_part1;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class KMOKOALA_ST10325173_POE_Part1 {

    /**
     * @param args the command line arguments
     */  
    private static String username = "";
    private static String password = "";
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login login = new Login();
        login.loginProcess();
    }
}

class Login{
    
private static final int MAX_ATTEMPTS = 3; 
//The user will have3 attempts to inut the correct Vallues in the 
//password and username if the user fails to dodo so the program will automatically exit the program
    
public void loginProcess(){

    for (int i = 0; i<MAX_ATTEMPTS; i++){
    
        String userName = getUserName();
        String passWord = getPassword();
        
        if (userName == null || passWord == null ){
        JOptionPane.showMessageDialog(null,"Login Canceled, Exiting.... ","Login",JOptionPane.ERROR_MESSAGE);
        System.exit(0);}
       
        if(checkUserName(userName)&& checkPassWordComplexity(passWord)){
        JOptionPane.showMessageDialog(null,"Password successfully Captured  ,Login Successful !" , "Login" ,JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Welcome back , " + userName + " ! Nice to see you again.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
        
      return;
       } else {
            JOptionPane.showMessageDialog(null,"Login unsuccessful ! Please Make sure you have entered the correct,"
                    + "\nUsername and ensure that it is no more than \n5 characters long and contains an underscore( _ ). "
                    + "\n" + "\nPassword should contain at least 8 charcaters ,\na capital letter ( A-Z ),a number( 0-9 ) and \n"
                    + "a special character( ?*&%.. )." , "Login" , JOptionPane.ERROR_MESSAGE);
        }
}
 JOptionPane.showMessageDialog(null, "Max attempts exceeded. Exiting the program.", "Login", JOptionPane.ERROR_MESSAGE); 
System.exit(0);
}

private String getUserName(){
    
JOptionPane.showMessageDialog(null,"Please enter a Username that contains \nan underscore and is \nno more than 5 characters long." );
String input = JOptionPane.showInputDialog("Please enter Your Name :  ");

if (input ==null){
    JOptionPane.showMessageDialog(null,"Login Canceled ,exiting. ","Login",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
   
}

if (!checkUserName (input)){
    JOptionPane.showMessageDialog(null,"Username is Incorrect. Please Try again.","Error", JOptionPane.ERROR_MESSAGE);
    return getUserName();
}

return input.trim();
}




private String getPassword(){
JOptionPane.showMessageDialog(null,"Please enter password of at least 8 characters,\na capital letter(A-Z) ,a number(0-9) also include a special character( ?%*&.. ).");

String input= JOptionPane.showInputDialog("Plese enter your password :");
if (input == null){
    JOptionPane.showMessageDialog(null,"Login Canceled, exiting.","Login",JOptionPane.ERROR_MESSAGE);
    System.exit(0);
}

if (!checkPassWordComplexity(input)){

    JOptionPane.showMessageDialog(null," Password is incorrect . Please try again. ", "Error", JOptionPane.ERROR_MESSAGE);
    return getPassword();
}//if statement that iterates evrytime the user enters an invalid if the pssword doesnt meet the requierments.

return input.trim(); 

//"8charcters ,aCapsletter,aNum and aSpecChar");
//the user needs to be promteed again if the users password doesnt meet the correct format at which is entered 
//the password should contain at least 8 charcaters ,a capital letter ,a number and a special character

}

private boolean checkUserName(String userName ){
return userName != null 
        && userName.length() <= 5 
        && userName.contains("_");
      

/*
This method chckswhether the users input fits the contined charateristics mentioned inthis method 
if the usersname that has been entered has a length of atleast 5 and it contains an underscore in it
*/
}


private boolean checkPassWordComplexity(String passWord){
return passWord.length()>=8
&& Pattern.compile("[A-Z]").matcher(passWord).find()
&& Pattern.compile("\\d").matcher(passWord).find()
&& Pattern.compile("[?%*&.@!$]").matcher(passWord).find();
       
/*
This Checkpasswordcomplexity checks if the password that has been provided and meeets the requirements for 
what values and characters should be at least included iin thier passwords
*/

}
}

