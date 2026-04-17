import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Nursetest {

    @Test
    public void testNurseHasNoAlertInitially() {
        Nurse nurse = new Nurse("Nurse-A", 0.6, 0.8);
        assertFalse(nurse.hasAlert());
    }

    @Test
    public void testNurseGetName() {
        Nurse nurse = new Nurse("Nurse-A", 0.6, 0.8);
        assertEquals("Nurse-A", nurse.getName());
    }

    @Test
    public void testNurseResolvesAlert() {
        Nurse nurse = new Nurse("Nurse-A", 1.0, 1.0);
        Hospital hospital = new Hospital(10);
        Queue completedAlerts = new Queue();

        Patient p = Patient.createPatient();
        hospital.addPatient(p);
        hospital.addAlert(new Alert(new Temperature(40.5), 0, new StarRating(3)));

        nurse.resolve(hospital, 10, completedAlerts, 0, 1);

        assertEquals(1, completedAlerts.count());
    }

    }
}