package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Position;
import everyway.everyway.repositories.Positions_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Positions_Service {

    @Autowired private Positions_Repository positions_Repository;

    /**
     * Retrieves a position by its ID.
     * 
     * This method queries the repository to find a position with the specified ID.
     * 
     * @param id the ID of the position to search for
     * @return the position with the specified ID, or null if not found
     */
    public Position findById ( int id ) {
        return positions_Repository.findById(id);
    }

    /**
     * Retrieves a list of positions by nation.
     * 
     * This method queries the repository to find positions associated with the specified nation.
     * 
     * @param nation the nation of the positions to search for
     * @return a list of positions that match the specified nation
     */
    public List<Position> findByNation ( String nation ) {
        return positions_Repository.findByNation(nation);
    }

    /**
     * Retrieves a list of positions by region/state.
     * 
     * This method queries the repository to find positions associated with the specified region/state.
     * 
     * @param region_state the region or state of the positions to search for
     * @return a list of positions that match the specified region/state
     */
    public List<Position> findByRegionState ( String region_state ) {
        return positions_Repository.findByRegionState(region_state);
    }

    /**
     * Retrieves a list of positions by province.
     * 
     * This method queries the repository to find positions associated with the specified province.
     * 
     * @param province the province of the positions to search for
     * @return a list of positions that match the specified province
     */
    public List<Position> findByProvince ( String province ) {
        return positions_Repository.findByProvince(province);
    }

    /**
     * Retrieves a list of positions by city/town.
     * 
     * This method queries the repository to find positions associated with the specified city/town.
     * 
     * @param city_town the city or town of the positions to search for
     * @return a list of positions that match the specified city/town
     */
    public List<Position> findByCityTown ( String city_town ) {
        return positions_Repository.findByCityTown(city_town);
    }

    /**
     * Retrieves a list of positions by address.
     * 
     * This method queries the repository to find positions associated with the specified address.
     * 
     * @param address the address of the positions to search for
     * @return a list of positions that match the specified address
     */
    public List<Position> findByAddress ( String address ) {
        return positions_Repository.findByAddress(address);
    }

    /**
     * Retrieves a list of positions by postal code.
     * 
     * This method queries the repository to find positions associated with the specified postal code.
     * 
     * @param postalcode the postal code of the positions to search for
     * @return a list of positions that match the specified postal code
     */
    public List<Position> findByPostalcode ( String postalcode ) {
        return positions_Repository.findByPostalcode(postalcode);
    }

    /**
     * Retrieves a list of all positions.
     * 
     * This method queries the repository to return all available positions in the database.
     * 
     * @return a list of all positions
     */
    public List<Position> findAll () {
        return positions_Repository.findAll();
    }
    
}