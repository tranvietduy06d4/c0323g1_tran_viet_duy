package model.Facility;

public class House extends Facility{
    private String houseStandard;
    private int houseFloorQuantity;

    public House() {
    }

    public House(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String houseStandard, int houseFloorQuantity) {
        super(serviceCode, serviceName, serviceArea, serviceFee, maximumPerson, rentType);
        this.houseStandard = houseStandard;
        this.houseFloorQuantity = houseFloorQuantity;
    }

    public String getHouseStandard() {
        return houseStandard;
    }

    public void setHouseStandard(String houseStandard) {
        this.houseStandard = houseStandard;
    }

    public int getHouseFloorQuantity() {
        return houseFloorQuantity;
    }

    public void setHouseFloorQuantity(int houseFloorQuantity) {
        this.houseFloorQuantity = houseFloorQuantity;
    }
}
