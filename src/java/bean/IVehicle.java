/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author luand
 */
public interface IVehicle {
    int getId();
    void setId(int id);
    
    Client getClient();
    void setClient(Client client);
}
