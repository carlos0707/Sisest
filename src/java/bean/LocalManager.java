/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.time.Duration;
import java.time.LocalDate;

/**
 *
 * @author luand
 */
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
            if (local.isEmpty()) {
                local.setVehicle(vehicle);
                local.setArrivalTime(LocalDate.now());
            }
        }
    }

    public long removeVehicle(int vehicleId) {
        for (Local local : locals) {            
            if (local.getVehicle() != null && local.getVehicle().getId() == vehicleId) {
                LocalDate time = local.getArrivalTime();
                Duration t = Duration.between(LocalDate.now(), time);
                local.setArrivalTime(null);
                return t.toHours();
            }
        }
        return -1;
    }
}
