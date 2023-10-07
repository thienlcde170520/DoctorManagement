package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class Library {
   
    private Scanner sc = new Scanner(System.in);
    
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public int inputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result > 0) return result;
                else {
                    System.err.println("Must be input number > 0!");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be input number!");
                System.out.print("Enter again: ");
            }
        }
    }
  
    public boolean inputYesNo() {
        while (true) {
            String result = inputString().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkIdExist(ArrayList<Doctor> doctors, String code) {
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(code)) {
                System.err.println("Id exist!");
                return false;
            }
        }
        return true;
    }
    
    public boolean checkChangeInfo(Doctor doctor, String code,String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}
