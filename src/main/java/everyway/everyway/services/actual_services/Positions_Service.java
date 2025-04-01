package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Position;
import everyway.everyway.repositories.Positions_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Positions_Service {

    @Autowired private Positions_Repository positions_Repository;

    public Position findById ( int id ) {
        return positions_Repository.findById(id);
    }

    public List<Position> findByNation ( String nation ) {
        return positions_Repository.findByNation(nation);
    }

    public List<Position> findByRegionState ( String region_state ) {
        return positions_Repository.findByRegionState(region_state);
    }

    public List<Position> findByProvince ( String province ) {
        return positions_Repository.findByProvince(province);
    }

    public List<Position> findByCityTown ( String city_town ) {
        return positions_Repository.findByCityTown(city_town);
    }

    public List<Position> findByAddress ( String address ) {
        return positions_Repository.findByAddress(address);
    }

    public List<Position> findByPostalcode ( String postalcode ) {
        return positions_Repository.findByPostalcode(postalcode);
    }

    public List<Position> findAll () {
        return positions_Repository.findAll();
    }
    
}