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

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public int getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(int serviceFee) {
        this.serviceFee = serviceFee;
    }

    public int getMaximumPerson() {
        return MaximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        MaximumPerson = maximumPerson;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceCode='" + serviceCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceArea=" + serviceArea +
                ", serviceFee=" + serviceFee +
                ", MaximumPerson=" + MaximumPerson +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
