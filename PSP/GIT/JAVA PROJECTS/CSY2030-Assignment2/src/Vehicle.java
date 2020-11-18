import java.io.Serializable;

abstract class Vehicle implements Serializable {
    private String model;
    private int topSpeed;
    private String registrationNumber;
    private double dailyHireRate;
    private boolean hired = false;

    Vehicle(String model, int topSpeed, String registrationNumber, double dailyHireRate) {
        this.model = model;
        this.topSpeed = topSpeed;
        this.registrationNumber = registrationNumber;
        this.dailyHireRate = dailyHireRate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", topSpeed=" + topSpeed +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", dailyHireRate=" + dailyHireRate +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getDailyHireRate() {
        return dailyHireRate;
    }

    public void setDailyHireRate(double dailyHireRate) {
        this.dailyHireRate = dailyHireRate;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }
}
