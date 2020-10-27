public class Endangered {
    public String getDanger() {
        return danger;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHealthy() {
        return healthy;
    }

    public Endangered(String danger, int age, String healthy) {
        this.danger = danger;
        this.age = age;
        this.healthy = healthy;
    }

    private String danger;
    private int id;
    private int age;
    private String healthy;



}
