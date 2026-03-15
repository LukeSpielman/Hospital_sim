import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {


    @Test
    void Hospital_hospitalHoldsPatients() {
Hospital hosp = new Hospital(10);
Patient p1 = Patient.createPatient();
hosp.addPatient(p1);
        Patient p2 = Patient.createPatient();
hosp.addPatient(p2);
        Patient p3 = Patient.createPatient();
hosp.addPatient(p3);
        Patient p4 = Patient.createPatient();
hosp.addPatient(p4);
        Patient p5 = Patient.createPatient();
hosp.addPatient(p5);
        Patient p6 = Patient.createPatient();
hosp.addPatient(p6);
        Patient p7 = Patient.createPatient();
hosp.addPatient(p7);
        Patient p8 = Patient.createPatient();
hosp.addPatient(p8);
        Patient p9 = Patient.createPatient();
hosp.addPatient(p9);
        Patient p10 = Patient.createPatient();
hosp.addPatient(p10);
hosp.printPatients();
System.out.print(hosp.getPatientCount());
    }

    @Test
    void Hospital_HoldsMoreThanCap() {
        Hospital hosp = new Hospital(10);
        Patient p1 = Patient.createPatient();
        hosp.addPatient(p1);
        Patient p2 = Patient.createPatient();
        hosp.addPatient(p2);
        Patient p3 = Patient.createPatient();
        hosp.addPatient(p3);
        Patient p4 = Patient.createPatient();
        hosp.addPatient(p4);
        Patient p5 = Patient.createPatient();
        hosp.addPatient(p5);
        Patient p6 = Patient.createPatient();
        hosp.addPatient(p6);
        Patient p7 = Patient.createPatient();
        hosp.addPatient(p7);
        Patient p8 = Patient.createPatient();
        hosp.addPatient(p8);
        Patient p9 = Patient.createPatient();
        hosp.addPatient(p9);
        Patient p10 = Patient.createPatient();
        hosp.addPatient(p10);
        Patient p11 = Patient.createPatient();
        hosp.addPatient(p11);
        hosp.printPatients();
        System.out.print(hosp.getPatientCount());
    }
}