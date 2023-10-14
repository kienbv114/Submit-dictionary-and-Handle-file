package model;

public class PersonModel implements Comparable<PersonModel> {

    private String name;
    private String address;
    private double money;

    public PersonModel() {
    }

    public PersonModel(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public int compareTo(PersonModel t) {
        return (int) (t.getMoney() - this.getMoney());
    }
}
