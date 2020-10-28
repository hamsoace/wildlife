package models;

public class AnimalRanger {
    private int id;
    private String name;
    private int badge;
    private String telephone;

    public AnimalRanger(String name, int badge, String telephone) {
        this.name = name;
        this.badge = badge;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
