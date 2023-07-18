package model.Facility;

public class Villa extends Facility{
    private String villaStandard;
    private int poolArea;
    private int villaFloorQuantity;

    public Villa() {
    }

    public Villa(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String villaStandard, int poolArea, int villaFloorQuantity) {
        super(serviceCode, serviceName, serviceArea, serviceFee, maximumPerson, rentType);
        this.villaStandard = villaStandard;
        this.poolArea = poolArea;
        this.villaFloorQuantity = villaFloorQuantity;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getVillaFloorQuantity() {
        return villaFloorQuantity;
    }

    public void setVillaFloorQuantity(int villaFloorQuantity) {
        this.villaFloorQuantity = villaFloorQuantity;
    }

    @Override
    public String toString() {
        return "- Villa " +super.toString() +" , Standard: " +this.getVillaStandard() +" , Pool Area: " +this.getPoolArea() +" , Floor Quantity: " +this.getVillaFloorQuantity();
    }
}
