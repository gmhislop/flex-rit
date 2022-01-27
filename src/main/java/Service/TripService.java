package Service;

import DTO.TripDTO;
import Exceptions.BadRequestException;
import Model.Trip;
import Model.User;
import Repository.TripRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    UserRepository userRepository;

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripsById(long id) {
        return tripRepository.findById(id);
    }
    public void addTrip(Trip trip) {
        Optional<User> user = userRepository.findById(trip.getUserId());
        if(user.isEmpty()) {
            throw new BadRequestException("Invalid user ID");
        }
        Trip t1 = new Trip();
        t1.setUser(user.get());
        t1.setFromLocation(trip.getFromLocation());
        t1.setToLocation(trip.getToLocation());
        t1.setDate(trip.getDate());
        t1.setDistance(trip.getDistance());
        t1.setUser(trip.getUser());
        t1.setVehicle(trip.getVehicle());
        tripRepository.save(t1);
    }

    public Optional<Trip> getTripById(long id) {
        return tripRepository.findById(id);
    }

    public void deleteTripById(long id) {
        tripRepository.deleteById(id);
    }

}