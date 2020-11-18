class MiniBus extends Vehicle
{
    private int seatingCapacity;

    MiniBus(String model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity)
    {
        super(model, topSpeed, registrationNumber, dailyHireRate);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity()
    {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity)
    {
        this.seatingCapacity = seatingCapacity;
    }
}
