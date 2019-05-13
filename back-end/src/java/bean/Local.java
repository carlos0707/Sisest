package bean;

import java.time.Duration;
import java.time.LocalDateTime;

public class Local {

    private int id;
    private IVehicle vehicle;
    private LocalDateTime arrivalTime;

    public Duration getTimeParked() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return Duration.between(arrivalTime, LocalDateTime.now());
    }

    public double getCost() {
        System.out.println("(getTimeParked().toMinutes() * 60) = " + (getTimeParked().toMinutes() * 60));
        System.out.println("vehicle.getCostHour() = " + vehicle.getCostHour());
        return (getTimeParked().toMinutes() * 60) * vehicle.getCostHour();
    }

    public boolean isEmpty() {
        return vehicle == null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
