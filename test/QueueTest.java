import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue queue = new Queue();
        queue.enqueue(new Alert(null,1,true));
        assertNotNull(queue.peek());
        assertEquals(1, queue.peek().getTimeRaised());
    }
    @Test
    void count() {
        Queue queue = new Queue();
        queue.enqueue(new Alert(null,1,true));
        queue.enqueue(new Alert(null,3,true));
        queue.enqueue(new Alert(null,1,false));
        queue.enqueue(new Alert(null,5,false));
        System.out.println(queue.count());
    }
    @Test
    void dequeue() {
        Queue queue = new Queue();
        queue.enqueue(new Alert(null,1,true));
        System.out.print(queue.count() + " ");
        queue.dequeue();
        System.out.print(queue.count());
    }
    @Test
    void peek() {
        Queue queue = new Queue();
        Observation o = new Temperature(40);
        assertNull(queue.peek());
        queue.enqueue(new Alert(o,1,true));
        System.out.print(queue.peek());
    }
}
