package models;

public class Location {
    private int id;
    private String name;
    private Animal animal;
    private int animalRangerId;
    private int locationId;

    public Location(String name, Animal animal, int animalRangerId, int locationId) {
        this.name = name;
        this.animal = animal;
        this.animalRangerId = animalRangerId;
        this.locationId = locationId;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getAnimalRangerId() {
        return animalRangerId;
    }

    public void setAnimalRangerId(int animalRangerId) {
        this.animalRangerId = animalRangerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
