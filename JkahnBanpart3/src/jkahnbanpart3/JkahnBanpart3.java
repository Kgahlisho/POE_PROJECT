/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jkahnbanpart3;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 * @author thee.Koala
 */


public class JkahnBanpart3 {

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
                return true; 
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
     
        if (username.length() <= 5 && username.contains("_")) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted.\nPlease ensure that your username contains an underscore and is no more than 5 characters in length.","Invalid Username", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean checkPasswordComplexity(String password) {
        if (password != null 
                && password.length() >= 8 
                && Pattern.compile("[A-Z]").matcher(password).find()
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

    public Task(String taskName, String taskDescription, int taskNumber, String developerDetails, int taskDuration,String taskStatus){
        
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
        
        String initials = taskName.length() >= 2? taskName.substring(0, 2): taskName.toUpperCase();
        String lastName = developerDetails.substring(developerDetails.lastIndexOf(" ") + 1).toUpperCase();
        String lastTwo = lastName.length() >=2? lastName.substring(lastName.length() - 2) : lastName;
        
        return initials + ":" + taskNumber + ":" + lastTwo;
    }

    public String printTaskDetails(){
        return "Task Number: "+ taskNumber +
                "\nTask Status: " + taskStatus +
                "\n-----------------------------" +
		"\nDeveloper Responsible : " + developerDetails + 
		"\nTask Name: " + taskName + 
		"\nTask Description: " + taskDescription + 
		"\nTask ID: " + taskID + 
		"\nDuration: " + taskDuration + " hrs";
    }

    
    //The job of < > is to create a generic class to be used as a parameeter
    //i made the task class to specify the parameter types in a ageneric class creation
    // This will return the total hours across all the tasks created in the program
       
    
    public static int returnTotalHours(List <Task> tasks) {
        int totalHours = 0;
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
    
    public String getTaskName(){
        return taskName;
    }
    
    public String getDeveloperDetails(){
        return developerDetails;
    }
    
    public String getTaskStatus(){
        return taskStatus;
    }
    
    public int getTaskNumber(){
        return taskNumber;
    }
    
}

class JKahnBane {
     
    private List<Task> tasks = new ArrayList<>();
   
    public void run() {
        JOptionPane.showMessageDialog(null, "Welcome to easyKahnban");
        
        int choice = 0;
     //   List< Task > tasks = new ArrayList<>();

        while (choice != 3) {
            String choiceStr = JOptionPane.showInputDialog("Select an option:\n1) Add tasks\n2) Show report\n3) Quit");
            if (choiceStr == null){
                System.exit(0);
            } 
            
            try {
                choice = Integer.parseInt(choiceStr);
            
            
            
                switch (choice) {
                    case 1:
                            addTasks();
                            break;

                    case 2:
                        showReport();
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting...");
                        break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        
        }catch (NumberFormatException e ){
                JOptionPane.showMessageDialog( null, "Invalid choice. Please enetr a valid Number.");
            }       
    }
}

    private void addTasks(){
        
     
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
                            if (taskDuration == null){
                                System.exit(0);
                            }
                      
                            int duration;
                                try{
                                    duration = Integer.parseInt(taskDuration);
                                }catch ( NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null , "Invalid duration. please enter avalid number.");
                                    i--;
                                    continue;
                                }
                        
                            String developerDetails = JOptionPane.showInputDialog("Enter developer details for task " + (i + 1) + ":");
                            if (developerDetails == null){
                                System.exit(0);
                            }
                            
                            String taskStatus = showTaskStatusMenu();
                            //String taskStatus = JOptionPane.showInputDialog("Enter task status for task" + (i+1) + ":");
                            if (taskStatus == null){
                                System.exit(0);
                            }
                        
                        Task task = new Task(taskName, taskDescription, i + 1, developerDetails, duration, taskStatus);
                        
                        if (task.checkTaskDescription()) {
                            tasks.add(task);
                    
                            JOptionPane.showMessageDialog(null, task.printTaskDetails());
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid task description. Please try again."); 
                            i--;
                        }
                    }

                    int totalHours = Task.returnTotalHours(tasks);
                    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                     
    }

private String showTaskStatusMenu(){

    String[] selection = {" To do. " , " Done. ", " Doing. "};
    int choice = JOptionPane.showOptionDialog(null, "Select task status. ", "Task status", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,selection,selection[0]);
     
        if (choice >=0 && choice < selection.length){
            return selection[choice];
        }else{
            return null;
        }
    }

private void showReport(){

    int choice = JOptionPane.showOptionDialog(null,"Select report Type: ","Report Menu ",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
            new String []{"Display Done Tasks. ", 
                "Display the Longest Task. ",
                "Search task by Name. ",
                "Search task by Developer. ", 
                "Delete task by Name. ",
                "Display Full Report. "},null);

    switch(choice){
        
        case 0:
            displayDoneTasks();
            break;
        
        case 1:
            displayLongestTask();
            break;
            
        case 2:
            searchTaskName();
            break;
         
        case 3:
            searchTasksByDeveloper();
            break;
         
        case 4: 
            deleteTask();
            break;
        
        case 5:
            displayReport();
            break;
            
        default: 
            JOptionPane.showMessageDialog(null,"invalid Choice ,Please try again. ");
        }
}


//This one doesnt display shit.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public void displayDoneTasks(){
    
    StringBuilder message = new StringBuilder();
    boolean foundtask = false;
    
    for (Task task : tasks){
       if (task.getTaskStatus().equalsIgnoreCase("Done")){
        JOptionPane.showMessageDialog(null, "Checking task: " + task.getTaskName() + " with status : " + task.getTaskStatus()); //debugging output
                  foundtask = true;
                
                message.append("Task Status : ").append(task.getTaskStatus()).append("\n");
                message.append("----------------------------------").append("\n");
                message.append("Developer Resposible : ").append(task.getDeveloperDetails()).append("\n");
                message.append("Task Name : ").append(task.getTaskName()).append("\n");
                message.append("Task Duration : ").append(task.getTaskDuration()).append("\n\n");
            }
       }
  
    if (foundtask ){
        JOptionPane.showMessageDialog(null, message.toString(), "Tasks with Status Done", JOptionPane.INFORMATION_MESSAGE);
    
    
    }else{   
        JOptionPane.showMessageDialog(null,"No task with done status " , "Tasks with status ( done )", JOptionPane.INFORMATION_MESSAGE);
    }    
    
}


public void displayLongestTask(){
 
    if (tasks.isEmpty()){
    
        JOptionPane.showMessageDialog(null,"No tasks avalible. ", "Longest Task",JOptionPane.INFORMATION_MESSAGE);
        return;
    }
        Task longestTask = tasks.get(0);
            for (Task task : tasks){
                if (task.getTaskDuration()> longestTask.getTaskDuration()){
                    longestTask = task;
                }
            }
    JOptionPane.showMessageDialog(null,"Developer Responsible : " + longestTask.getDeveloperDetails() 
            + "\n------------------------------"
            + "\nTask Name: " + longestTask.getTaskName()
            +  "\nDuration: " + longestTask.getTaskDuration() + " hrs" 
            , " Longest Task ",JOptionPane.INFORMATION_MESSAGE);
    
}
    
public void searchTaskName(){

    String taskName = JOptionPane.showInputDialog("Enter the Name of the Task you want to search for: ");
    if (taskName == null){
        return;
    }
    
    StringBuilder message = new StringBuilder();
        for (Task task : tasks){
            if (task.getTaskName().equalsIgnoreCase(taskName)){
                message.append("Searched Task :").append(task.getTaskName()).append("\n");
                message.append("----------------------------------").append("\n");
                message.append("Task Name: ").append(task.getTaskName()).append("\n");
                message.append("Developer Responsible: ").append(task.getDeveloperDetails()).append("\n");
                message.append("Task status: ").append(task.getTaskStatus()).append("\n\n");
            }
        }
        
        if (message.length() == 0){
            message.append (" Found no task with the name: ").append(taskName);
        }
        
    JOptionPane.showMessageDialog(null, message.toString(), "Search Task by Name", JOptionPane.INFORMATION_MESSAGE);
}

public void searchTasksByDeveloper(){

    String developer = JOptionPane.showInputDialog("Enter the name of the Developer responsible for the task : ");
          if (developer == null ){
            return;
        }
          
          StringBuilder message = new StringBuilder();
            for (Task task : tasks){
                if (task.getDeveloperDetails().equalsIgnoreCase(developer)){
                    message.append("Developer Name: ").append(task.getDeveloperDetails()).append("\n");
                    message.append("----------------------------------").append("\n");
                    message.append("Task name: ").append(task.getTaskName()).append("\n");
                    message.append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
                }
                }
            if (message.length() == 0){
                message.append("No task found for developer : ").append(developer);
            }
            JOptionPane.showMessageDialog(null, message.toString(),"Search task by developer.",JOptionPane.INFORMATION_MESSAGE);
    }
          
public void deleteTask(){

    String taskName = JOptionPane.showInputDialog("Enter the task name you would like to delete: ");
        if (taskName == null){
            return;
        }

        Task taskToRemove = null ;
            for (Task task : tasks){
                if (task.getTaskName().equalsIgnoreCase(taskName)){
                    taskToRemove = task;
                    break;
                }
            }
            if (taskToRemove != null){
                tasks.remove(taskToRemove);
                JOptionPane.showMessageDialog(null,"Task : " + taskName + " Has been deleted. ", "Delete Task" ,JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"No task found with the name : " + taskName ,"Delete task ",JOptionPane.ERROR_MESSAGE);
            }
}

//This one doesnt display shit

public void displayReport(){

    StringBuilder message = new StringBuilder();
        
        if (tasks.isEmpty()){
            JOptionPane.showMessageDialog(null, "No tasks to display. " , "Full Report" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            for (Task task : tasks){
                message.append("----------------------------------------------------").append("\n");
                message.append("Task number : ").append("[ ").append(task.getTaskNumber()).append(" ]").append("\n");
                message.append("Developer Responsible : ").append(task.getDeveloperDetails()).append("\n");
                message.append("---------------------------------------").append("\n");
                message.append("Task Name : ").append(task.getTaskName()).append("\n");
                message.append("Task ID : ").append("[ ").append(task.getTaskID()).append(" ]").append("\n");
                message.append("Task Duration: ").append(task.getTaskDuration()).append("hrs").append("\n\n");
                message.append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
                     
            }
            JOptionPane.showMessageDialog(null, message.toString(),"Full report", JOptionPane.INFORMATION_MESSAGE);   
        }
}
}
