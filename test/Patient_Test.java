import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class Patient_Test {

    @Test
    public void testPatientIdNotNull() {
        Patient p = new Patient();
        assertNotNull(p.getPatientId());
    }

    @Test
    public void testPatientIdsUnique() {
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        Patient p3 = new Patient();
        Patient p4 = new Patient();

        UUID id1 = p1.getPatientId();
        UUID id2 = p2.getPatientId();
        UUID id3 = p3.getPatientId();
        UUID id4 = p4.getPatientId();

        assertNotEquals(id1, id2);
        assertNotEquals(id1, id3);
        assertNotEquals(id1, id4);

        assertNotEquals(id2, id3);
        assertNotEquals(id2, id4);

        assertNotEquals(id3, id4);}
    @Test
    public void testStringContainsId() {
        Patient p = new Patient();
        String s = p.toString();
        assertNotNull(s);
        assertTrue(s.contains(p.getPatientId().toString()));
    }
}