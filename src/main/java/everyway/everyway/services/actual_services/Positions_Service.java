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
     * @param id The unique identifier of the position.
     * @return Position - The position with the specified ID, or null if not found.
     */
    public Position findById ( int id ) {
        return positions_Repository.findById(id);
    }

    /**
     * Retrieves a list of positions by nation.
     *
     * @param nation The nation to filter positions by.
     * @return List<Position> - A list of positions that match the specified nation.
     */
    public List<Position> findByNation ( String nation ) {
        return positions_Repository.findByNation(nation);
    }

    /**
     * Retrieves a list of positions by region/state.
     *
     * @param region_state The region or state to filter positions by.
     * @return List<Position> - A list of positions that match the specified region/state.
     */
    public List<Position> findByRegionState ( String region_state ) {
        return positions_Repository.findByRegionState(region_state);
    }

    /**
     * Retrieves a list of positions by province.
     *
     * @param province The province to filter positions by.
     * @return List<Position> - A list of positions that match the specified province.
     */
    public List<Position> findByProvince ( String province ) {
        return positions_Repository.findByProvince(province);
    }

    /**
     * Retrieves a list of positions by city/town.
     *
     * @param city_town The city or town to filter positions by.
     * @return List<Position> - A list of positions that match the specified city/town.
     */
    public List<Position> findByCityTown ( String city_town ) {
        return positions_Repository.findByCityTown(city_town);
    }

    /**
     * Retrieves a list of positions by address.
     *
     * @param address The address to filter positions by.
     * @return List<Position> - A list of positions that match the specified address.
     */
    public List<Position> findByAddress ( String address ) {
        return positions_Repository.findByAddress(address);
    }

    /**
     * Retrieves a list of positions by postal code.
     *
     * @param postalcode The postal code to filter positions by.
     * @return List<Position> - A list of positions that match the specified postal code.
     */
    public List<Position> findByPostalcode ( String postalcode ) {
        return positions_Repository.findByPostalcode(postalcode);
    }

    /**
     * Retrieves a list of all positions.
     *
     * @return List<Position> - A list of all positions in the database.
     */
    public List<Position> findAll () {
        return positions_Repository.findAll();
    }
    
}