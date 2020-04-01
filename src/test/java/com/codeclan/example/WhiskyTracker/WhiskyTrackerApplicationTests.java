package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByName(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByName("The Glendronach Revival");
		assertEquals(1, foundWhisky.size());
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

	@Test
	public void canFindWhiskiesByAge(){
		List<Whisky> foundWhiskyAge = whiskyRepository.findAllWhiskiesByAge(12);
		assertEquals(2, foundWhiskyAge.size());
	}

	@Test
	public void canFindWhiskyByRegion(){
		List<Distillery> foundRegion = distilleryRepository.findByRegion("Speyside");
		assertEquals(2, foundRegion.size());
	}

//	@Test
//	public void canFindWhiskyByDistilleryAndAge(){
//		List<Whisky> foundWhiskyByAge = whiskyRepository.findWhiskyByDistilleryAndAge("Rosebank", 12);
//		assertEquals(1, foundWhiskyByAge.size());
//	}


}
