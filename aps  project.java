import java.util.*;

/**
 * E-Healthcare Management System
 * Author: Avika Gupta
 * Simple console-based Java project for Algorithmic Problem Solving
 */

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println(id + "\t" + name + "\t" + age + "\t" + disease);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println(id + "\t" + name + "\t" + specialization);
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String date;

    Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public void display() {
        System.out.println(patientId + "\t" + doctorId + "\t" + date);
    }
}

public class EHealthcareSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== E-Healthcare Management System =====");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Search Patient");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: managePatients(); break;
                case 2: manageDoctors(); break;
                case 3: manageAppointments(); break;
                case 4: searchPatient(); break;
                case 5: generateReport(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // ========== PATIENT MANAGEMENT ==========
    static void managePatients() {
        int ch;
        do {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: addPatient(); break;
                case 2: viewPatients(); break;
                case 3: deletePatient(); break;
                case 4: break;
                default: System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }

    static void addPatient() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        System.out.println("\nID\tName\tAge\tDisease");
        for (Patient p : patients)
            p.display();
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        patients.removeIf(p -> p.id == id);
        System.out.println("Patient deleted successfully!");
    }

    // ========== DOCTOR MANAGEMENT ==========
    static void manageDoctors() {
        int ch;
        do {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: addDoctor(); break;
                case 2: viewDoctors(); break;
                case 3: deleteDoctor(); break;
                case 4: break;
                default: System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }

    static void addDoctor() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();
        doctors.add(new Doctor(id, name, spec));
        System.out.println("Doctor added successfully!");
    }

    static void viewDoctors() {
        System.out.println("\nID\tName\tSpecialization");
        for (Doctor d : doctors)
            d.display();
    }

    static void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = sc.nextInt();
        doctors.removeIf(d -> d.id == id);
        System.out.println("Doctor deleted successfully!");
    }

    // ========== APPOINTMENT MANAGEMENT ==========
    static void manageAppointments() {
        int ch;
        do {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Delete Appointment");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: addAppointment(); break;
                case 2: viewAppointments(); break;
                case 3: deleteAppointment(); break;
                case 4: break;
                default: System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }

    static void addAppointment() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(pid, did, date));
        System.out.println("Appointment added successfully!");
    }

    static void viewAppointments() {
        System.out.println("\nPatientID\tDoctorID\tDate");
        for (Appointment a : appointments)
            a.display();
    }

    static void deleteAppointment() {
        System.out.print("Enter Patient ID to delete appointment: ");
        int id = sc.nextInt();
        appointments.removeIf(a -> a.patientId == id);
        System.out.println("Appointment deleted successfully!");
    }

    // ========== SEARCH & REPORT ==========
    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient Found!");
                p.display();
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    static void generateReport() {
        System.out.println("\n===== Healthcare Report =====");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Appointments: " + appointments.size());
    }
}
