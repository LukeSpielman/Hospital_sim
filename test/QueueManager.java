public class QueueManager {
    private Queue urgentQueue;
    private Queue normalQueue;

    public QueueManager() {
        urgentQueue = new Queue();
        normalQueue = new Queue();
    }

    public void addAlert(Alert alert) {
        if (alert.isUrgent()) {
            urgentQueue.enqueue(alert);
        } else {
            normalQueue.enqueue(alert);
        }
    }
    public Alert getNextAlert() {
        if (urgentQueue.count() > 0) {
            return urgentQueue.dequeue();
        } else if (normalQueue.count() > 0) {
            return normalQueue.dequeue();
        } else {
            return null;
        }
    }

    public int getUrgentCount() {
        return urgentQueue.count();
    }
    public int getNormalCount() {
        return normalQueue.count();
    }
}
