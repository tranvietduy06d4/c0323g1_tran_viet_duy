package model.Facility;

public class Room extends Facility{
    private String freeAdditionService;

    public Room() {
    }

    public Room(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String freeAdditionService) {
        super(serviceCode, serviceName, serviceArea, serviceFee, maximumPerson, rentType);
        this.freeAdditionService = freeAdditionService;
    }

    public String getFreeAdditionService() {
        return freeAdditionService;
    }

    public void setFreeAdditionService(String freeAdditionService) {
        this.freeAdditionService = freeAdditionService;
    }

    @Override
    public String toString() {
        return "- Room: " + super.toString() +" , Free additional service: " +this.getFreeAdditionService();
    }
}
