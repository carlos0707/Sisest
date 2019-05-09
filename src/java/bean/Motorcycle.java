package bean;

public class Motorcycle implements IVehicle {

    public Motorcycle(int id, Client client) {
        this.id = id;
        this.client = client;
    }

    private int id;
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
