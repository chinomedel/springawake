package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.persistence.entity.City;
import cl.awakelab.m1spring.persistence.repository.CityRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    Log logger = LogFactory.getLog(CityService.class);

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAll(){
        List<City> filtrados = repository.getAllByCountryId(2);
        filtrados.forEach(city -> logger.info(city.toString()));

        return repository.getAll();
    }
}
