package com.example.GetRide.Repository;

import com.example.GetRide.Model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CabRepository extends JpaRepository<Cab,Integer>
{
    @Query(value = "SELECT * FROM cab WHERE cab_is_booked = 0 ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Optional<Cab> getRandomAvailableCab();//optional as cab maybe empty
}
