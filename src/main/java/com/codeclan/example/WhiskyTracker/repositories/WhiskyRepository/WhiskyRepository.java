package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky>findWhiskyByName(String name);

    List<Whisky>findAllWhiskiesByAge(int age);

    List<Whisky>findWhiskyByDistilleryAndAge(String name, int age);


}
