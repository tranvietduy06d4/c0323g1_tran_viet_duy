package model.Facility;

public class Facility {
    private String serviceCode;
    private String serviceName;
    private int serviceArea;
    private int serviceFee;
    private int MaximumPerson;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceFee = serviceFee;
        MaximumPerson = maximumPerson;
        this.rentType = rentType;
    }
}
