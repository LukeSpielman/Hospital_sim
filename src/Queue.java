public class Queue {
    private QueueRecord head, tail;


    public void enqueue( Alert al){
        QueueRecord rec = new QueueRecord(al);
        if(tail!= null) {
            tail.next = rec;
            tail=rec;
        } else {
            head = rec;
            tail = rec;
        }
    }
    public Alert dequeue () {
        if (head == null) {
            return null;
        }

        Alert result = head.alert;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return result;
    }
    public Alert peek(){
        if(head == null) {
            return null;
        }
        return head.alert;
    }
    public int count(){
        QueueRecord rec = head;
        int ct = 0;
        while (rec!= null) {
            ct++;
            rec = rec.next;
        }
        return ct;
    }

    private class QueueRecord {
        Alert alert;
        QueueRecord next;

        public QueueRecord (Alert al){
            this.alert = al;
            this.next = null;
        }
    }

}
