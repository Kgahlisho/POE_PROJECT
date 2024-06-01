/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jkhahnban;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 * @author thee.Koala
 */


public class Kmokoala_St10325173_Jkhahnbanepart2 {

    public static void main(String[] args) {
        Login login = new Login();
        if (login.loginProcess()) {
            JKahnBane arraytasks = new JKahnBane();
            arraytasks.run();
        }
    }
}
class Login {
    private boolean loggedIn = false;
    private int loginAttempts = 0;

    public boolean loginProcess() {
        while (loginAttempts < 3) {
            String name = getUsername();

            if (name == null) {
                JOptionPane.showMessageDialog(null, "Login canceled. Exiting the program.", "Login", JOptionPane.ERROR_MESSAGE);
                return false; // returns an appropriate statement 
            }

            String pass = getPassword();

            if (pass == null) {
                JOptionPane.showMessageDialog(null, "Login canceled. Exiting the program.", "Login", JOptionPane.ERROR_MESSAGE);
                return false;  // returns an appropriate statement 
            }

            if (checkUserName(name) && checkPasswordComplexity(pass)) {
                loggedIn = true;
                JOptionPane.showMessageDialog(null, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Welcome back, " + name + "! Nice to see you again.",
                        "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                return true; // Returns true to indicate that the login is successesfull
            } else {
                loginAttempts++;

                if (loginAttempts < 3) {
                    JOptionPane.showMessageDialog(null, "Login unsuccessful! Please try again.", "Login",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "You have tried too many times. Goodbye!", "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Max attempts exceeded. Exiting the program.", "Login", JOptionPane.ERROR_MESSAGE);
        return false; // Return false to indicate login failure
    }
private String getUsername() {
    String input;
    input = JOptionPane.showInputDialog("Please enter username (5 characters and an underscore): ");
    if (input == null) {
    System.exit(0); // Exit the program if the user presses the cancel button
    }
    return input.replaceAll("\\s+", "");
}

private String getPassword() {
    String input;
    input = JOptionPane.showInputDialog("Please enter your password:");
    if (input == null) {
    System.exit(0); // Exit the program if the user presses the cancel button
    }
    return input;
}
  
private boolean checkUserName(String username) {
        if (username == null || username.length() <= 5 || username.contains("_")) {
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted.\nPlease ensure that your username contains an underscore and is no more than 5 characters in length.","Invalid Username", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean checkPasswordComplexity(String password) {
        if (password != null 
                && password.length() >= 8 && Pattern.compile("[A-Z]").matcher(password).find()
                && Pattern.compile("\\d").matcher(password).find()
                && Pattern.compile("[!@#%^&*()+$_]").matcher(password).find()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, """
                                                Password is not correctly formatted.
                                                Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.""",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

class Task {
    private String taskName;
    private String taskDescription;
    private int taskNumber;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, int taskNumber, String developerDetails, int taskDuration,
            String taskStatus){
        
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription(){
        return taskDescription.length() <= 50;
    }

    public String createTaskID(){
        
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastName = developerDetails.substring(developerDetails.lastIndexOf(" ") + 1).toUpperCase();
        String lastTwo = lastName.substring(Math.max(0, lastName.length()-2));
        
        return initials + ":" + taskNumber + ":" + lastTwo;
    }

    public String printTaskDetails(){
        return "Task Status: " + taskStatus + 
		"\nDeveloper Details: " + developerDetails + 
		"\nTask Number: "+ taskNumber + 
		"\nTask Name: " + taskName + 
		"\nTask Description: " + taskDescription + 
		"\nTask ID: " + taskID + 
		"\nDuration: " + taskDuration + " hrs";
    }

    
    //The job of < > is to create a generic class to be used as a parameeter
    //i made the task class to specify the parameter types in a ageneric class creation
    // This will return the total hours across all the tasks created in the program
       
    
    public static int returnTotalHours(List <Task> tasks) { int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    public int getTaskDuration(){
        return taskDuration;
    }

    public String getTaskID(){
        return taskID;
    }
}

class JKahnBane {
    public void run() {
        JOptionPane.showMessageDialog(null, "Welcome to easyKahnban");
        
        int choice = 0;
        List< Task > tasks = new ArrayList<>();

        while (choice != 3) {
            String choiceStr = JOptionPane.showInputDialog("Select an option:\n1) Add tasks\n2) Show report\n3) Quit");
            if (choiceStr == null){
            System.exit(0);
            }
            choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    String numTasksStr = JOptionPane.showInputDialog("Enter the number of tasks");
                   if (numTasksStr == null){
                   System.exit(0);
                   }
                   int numTasks = Integer.parseInt(numTasksStr);

                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter the task name " + (i + 1) + ":");
                        if (taskName == null){
                        System.exit(0);
                        }
                        
                        String taskDescription = JOptionPane.showInputDialog("Enter the task's description " + (i + 1) + ":");
                        if (taskDescription == null){
                        System.exit(0);
                        }
                        
                        String taskDuration = JOptionPane.showInputDialog("Enter the duration in hours " + (i + 1) + ":");
                        if (taskDescription == null){
                        System.exit(0);
                        }
                      
                        int duration = Integer.parseInt(taskDuration);
                            
                        String developerDetails = JOptionPane.showInputDialog("Enter developer details for task " + (i + 1) + ":");

                        if (developerDetails == null){
                        System.exit(0);
                        }
                        
                        
                        Task task = new Task(taskName, taskDescription, i + 1, developerDetails, duration, "");
                        
                        if (task.checkTaskDescription()) {
                            tasks.add(task);
                            JOptionPane.showMessageDialog(null, "Task successfully added");
                            JOptionPane.showMessageDialog(null, "Task successfully added. Task ID: " + task.getTaskID());
                        } else 
                     {
                            JOptionPane.showMessageDialog(null, "Invalid task description. Please try again."); 
                            i--;
                        }
                    }

                    int totalHours = Task.returnTotalHours(tasks);
                    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
