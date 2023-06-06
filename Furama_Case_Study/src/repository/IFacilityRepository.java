package repository;

import model.Facility.Facility;
import repository.impl.FacilityRepository;

import java.util.Map;

public interface IFacilityRepository{
    public Map<Facility,Integer> getAll();

    public Facility getByCode(String facilityCode);

    public void addNew(Facility facility);


    void deleteFacility(Facility facility);


}
