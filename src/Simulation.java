import java.util.Random;

public class Simulation {

        private static Random rand = new Random();

        public static Random getRandom() {
            return rand;
        }


        private int totalTime = 600;
        private int currentTime = 0;


        private Hospital hospital;


        public Simulation() {}


        public void setup() {
            hospital = new Hospital(50);
            currentTime = 0;
        }


        public void run() {
            while (currentTime <= totalTime) {
                processStep();
                currentTime += 10;
            }

            process();
        }


        private void processStep() {


            if (rand.nextInt(100) < 66) {
                Patient p = Patient.createPatient();
                hospital.addPatient(p);
                System.out.println("Time " + currentTime + ": New patient admitted.");
            }
        }


        public void process() {
            System.out.println("Simulation finished.");
            System.out.println("Total patients admitted: " + hospital.getPatientCount());
            hospital.printPatients();
        }
    }

