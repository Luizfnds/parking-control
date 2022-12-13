package com.lefnds.parkingcontrol.services;

import com.lefnds.parkingcontrol.models.ParkingSpotModel;
import com.lefnds.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository repository;

    public List<ParkingSpotModel> findAll() {
        return repository.findAll();
    }

    public ParkingSpotModel findById(UUID id) {
        return repository.findById(id).get();
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }

    public ParkingSpotModel update(UUID id, ParkingSpotModel p) {
        ParkingSpotModel entity = repository.findById(id).get();
        return repository.save(entity);
    }

    public void delete(UUID id) {
        ParkingSpotModel entity = repository.findById(id).get();
        repository.delete(entity);
    }
}
