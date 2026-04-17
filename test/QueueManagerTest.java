import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagerTest {

    @Test
    void addAlert() {
        QueueManager q = new QueueManager();
        Alert urgent = new Alert(null, 1, true);
        Alert normal = new Alert(null, 2, false);

        q.addAlert(urgent);
        q.addAlert(normal);

        assertEquals(1, q.getUrgentCount());
        assertEquals(1, q.getNormalCount());
    }
    @Test
    void urgentPriority() {
        QueueManager q = new QueueManager();
        Alert normal1 = new Alert(null, 1, false);
        Alert urgent = new Alert(null, 2, true);
        Alert normal2 = new Alert(null, 3, false);

        q.addAlert(normal1);
        q.addAlert(urgent);
        q.addAlert(normal2);

        Alert first = q.getNextAlert();
        assertTrue(first.isUrgent());
        assertEquals(2, first.getTimeRaised());
    }
    @Test
    void emptyQueue() {
        QueueManager q = new QueueManager();
        assertNull(q.getNextAlert());
    }
    @Test
    void nextAlert() {
        QueueManager q = new QueueManager();
        q.addAlert(new Alert(null, 2, true));
        q.addAlert(new Alert(null, 1, false));
        q.getNextAlert();

        assertEquals(0, q.getUrgentCount());
        assertEquals(1, q.getNormalCount());
    }
}