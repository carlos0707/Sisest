package bean;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalManager {

    private final Local[] locals;

    public LocalManager(int size) {
        locals = new Local[size];
        for (int i = 0; i < size; i++) {
            locals[i] = new Local();
        }
    }

    public void insertVehicle(IVehicle vehicle) {
        for (Local local : locals) {
            if (!local.isEmpty()) {
                continue;
            }
            local.setVehicle(vehicle);
            local.setArrivalTime(LocalDateTime.now());
            break;
        }
    }

    public long removeVehicle(int vehicleId) {
        for (Local local : locals) {
            if (!local.isEmpty() && local.getVehicle().getId() == vehicleId) {
                LocalDateTime time = local.getArrivalTime();
                Duration t = Duration.between(LocalDate.now(), time);
                local.setArrivalTime(null);
                return t.toHours();
            }
        }
        return -1;
    }

    public int getVagasLivres() {
        int count = 0;
        for (Local local : locals) {
            if (local.isEmpty()) {
                count += 1;
            }
        }
        return count;
    }

    public double getCost(int vehicleId) {
        for (Local local : locals) {
            if (!local.isEmpty() && local.getVehicle().getId() == vehicleId) {
                return local.getCost();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LocalManager m = new LocalManager(2);
        Client client = new Client(1, "Carlos", "josecarlos@gmail", "3269-3262");
        Motorcycle moto = new Motorcycle(1, client);
        Car car = new Car(1, client);
        System.out.println("Vagas livres: " + m.getVagasLivres());
        m.insertVehicle(car);
        System.out.println("Vagas livres: " + m.getVagasLivres());
        m.insertVehicle(moto);
        System.out.println("Vagas livres: " + m.getVagasLivres());
        try {
            Thread.sleep((long) (1000 * 60));
        } catch (InterruptedException ex) {
            Logger.getLogger(LocalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(m.getCost(1));

    }
}
