package controller;

import common.Library;
import java.util.ArrayList;
import model.Doctor;

import view.Menu;

public class Manager extends Menu<String>{
    static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    ArrayList<Doctor> doctors = new ArrayList<>();
    
    private Library library;
    
    public Manager(Doctor doctor) {
        super("===================== Doctor Management =====================", mc);
        library = new Library();
    }

   

    public void createDoctor(ArrayList<Doctor> doctors) {            
        while (true) {
            System.out.print("Enter code: ");
            String code = library.inputString();
            System.out.print("Enter name: ");
            String name = library.inputString();
            System.out.print("Enter specialization: ");
            String specialization = library.inputString();
            System.out.print("Enter availability: ");
            int availability = library.inputInt();

            Doctor d = new Doctor(code, name, specialization, availability);
            if (library.checkIdExist(doctors, code)) {
                doctors.add(d);
            System.err.println("Create success!");
            }

                System.out.print("Do you want to create more students (Y/N): ");
            if (!library.inputYesNo()) {
                return;
            }
            
        }
    }
    
    public void updateDoctor(ArrayList<Doctor> doctors) {
        Doctor updateDoctor = searchDoctorByID(doctors);
        if (updateDoctor == null) return;
        else { 
            System.out.print("Enter code new: ");
            String codeUpdate = library.inputString();
            System.out.print("Enter name new: ");
            String updateName = library.inputString();
            System.out.print("Enter specialization new: ");
            String updateSpecialization = library.inputString();
            System.out.print("Enter availability new: ");
            int updateAvailability = library.inputInt();
            if (library.checkChangeInfo(updateDoctor ,codeUpdate, updateName, updateSpecialization, updateAvailability)){
            updateDoctor.setCode(codeUpdate);
            updateDoctor.setName(updateName);
            updateDoctor.setSpecialization(updateSpecialization);
            updateDoctor.setAvailability(updateAvailability);
            System.out.println("Update successful!");
        }
        else {
            System.out.println("Nothing change!");
        }
        }
    }
    
    public Doctor searchDoctorByID(ArrayList<Doctor> doctors) {
        System.out.println("Enter code:");
        String idSearch = library.inputString();
        int count = 0;
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(idSearch)) {   
                count++;
                return d;
            }
        }
        if (count == 0) {
            System.out.println("Not Found!");
        }
        return null;
    }
    
    public void searchDoctor(ArrayList<Doctor> doctors) {
        System.out.print("Enter name: ");
        String nameSearch = library.inputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(doctors, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }
    
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> doctors, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getName().toLowerCase().contains(name.toLowerCase())) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    //allow user delete contact
    public void deleteDoctor(ArrayList<Doctor> doctors) {
        System.out.print("Enter id: ");
        String idDelete = library.inputString();
        Doctor doctorDelete = getDoctorById(doctors, idDelete);
        if (doctorDelete == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            doctors.remove(doctorDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public Doctor getDoctorById(ArrayList<Doctor> doctors, String codeDelete) {
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(codeDelete)) {
                return d;
            }
        }
        return null;
    }    
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createDoctor(doctors);
                break;
            case 2:
                updateDoctor(doctors);
                break;
            case 3:
                deleteDoctor(doctors);
                break;
            case 4:
                searchDoctor(doctors);
                break;
            case 5:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }   
    

}