package repository.impl;

import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;
import repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FacilityRepository implements IFacilityRepository {
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

//    public Villa(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String villaStandard, int poolArea, int villaFloorQuantity) {

    static {
        facilityMap.put(new House("SVHO-0001", "Rent House", 100, 4000000, 6, "Day", "VIP", 2), 5);
        facilityMap.put(new Room("SVRO-0001", "Rent Room", 35, 60000000, 4, "Month", "Free Cleaner"), 2);
        facilityMap.put(new Villa("SVVL-0001", "Rent Villa", 300, 10000000, 12, "Day", "Standard", 50, 3), 5);
    }


    @Override
    public Map<Facility, Integer> getAll() {
        return facilityMap;
    }

    @Override
    public Facility getByCode(String facilityCode) {
        Set<Facility> facilitySet = facilityMap.keySet();
        for (Facility f : facilitySet) {
            if (f.getServiceCode().equals(facilityCode)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void addNew(Facility facility) {
        facilityMap.put(facility, 0);
    }

    @Override
    public void deleteFacility(Facility facility) {
        facilityMap.remove(facility);
    }
}



