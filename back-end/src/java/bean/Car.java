package bean;

public class Car implements IVehicle {

    private int id;

    public Car(int id, Client client) {
        this.id = id;
        this.client = client;
    }
    private Client client;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public double getCostHour() {
        return 10;
    }

}
