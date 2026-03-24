import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @Test
    void createsRoutineUnresolvedAlert() {
        Observation o = new Temperature(40);
        Alert a = new Alert(o, 10, false);

        System.out.println(a);

        assertNotNull(a);
        assertEquals(10, a.getTimeRaised());
        assertFalse(a.isUrgent());
        assertFalse(a.isResolved());
        assertTrue(a.toString().contains("ROUTINE"));
        assertTrue(a.toString().contains("unresolved"));
    }

    @Test
    void resolvesAlert() {
        Observation o = new Temperature(43);
        Alert a = new Alert(o, 5, true);

        a.resolve(20);

        System.out.println(a);

        assertTrue(a.isUrgent());
        assertTrue(a.isResolved());
        assertEquals(20, a.getTimeResolved());
        assertTrue(a.toString().contains("URGENT"));
        assertTrue(a.toString().contains("resolved@20"));
    }
}