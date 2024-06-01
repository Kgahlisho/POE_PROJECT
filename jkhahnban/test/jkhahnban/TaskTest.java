/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package jkhahnban;


import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kgahlisho
 */
public class TaskTest {
    
    private Task task;
    
    public TaskTest() {
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        assertTrue(task.checkTaskDescription());
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        assertEquals("DE:1:OE",task.createTaskID());
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        
        String expectedDetails = "Task status : In progress ";
        assertEquals(expectedDetails,task.printTaskDetails());
        
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        List < Task > tasks =new ArrayList<>();
        tasks.add(task);
        tasks.add(new Task (" TestTask" , " Another description ", 2 , " John doe " , 5 , "To do"));
    
        assertEquals(15, Task.returnTotalHours(tasks));
        
        
    }

    /**
     * Test of getTaskDuration method, of class Task.
     */
    @Test
    public void testGetTaskDuration() {
    }

    /**
     * Test of getTaskID method, of class Task.
     */
    @Test
    public void testGetTaskID() {
    }
    
}
