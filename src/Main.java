/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import model.Doctor;
import controller.Manager;
public class Main {

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        
        new Manager(doctor).run();
    }
    
}
