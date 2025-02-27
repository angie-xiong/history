package com.neoworks.interviewtests.graph.exercise;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.neoworks.interviewtests.graph.constant.Constants;
import com.neoworks.interviewtests.graph.entity.Relationship;
import com.neoworks.interviewtests.graph.entity.User;
import com.neoworks.interviewtests.graph.service.ExerciseService;

/**
 * Unit tests for exercises
 * 
 * @author Angie.xiong
 * @param <T>
 *
 */
public class ExerciseTest {

	ExerciseService exerciseService = new ExerciseService();

	Map<String, Class<?>> fileConnections = new HashMap<String, Class<?>>();

	// Initialize the relationship between java bean and file name
	public void init() {
		fileConnections.put(Constants.CSV_FILENAME_PEOPLE, User.class);
		fileConnections.put(Constants.CSV_FILENAME_RELATIONSHIP, Relationship.class);
	}

	/**
	 * Exercise 1: implement code and data structures that read the files
	 */
	@Test
	public void exercise1Test() {
		System.out.println("****************************Exercise 1 begins *********************************");
		init();
		exerciseService.loadData();
		exerciseService.createBeans(fileConnections);
		System.out.println("****************************Exercise 1 ended *********************************");
		System.out.println();
	}

	/**
	 * Exercise 2: Validate correct people loaded
	 */
	@Test
	public void exercise2Test() {
		System.out.println();
		System.out.println("****************************Exercise 2 begins *********************************");

		// Loading data and initial beans
		exercise1Test();

		int peopleNumInFile = exerciseService.loadedOriginalData.get(Constants.CSV_FILENAME_PEOPLE).size();
		System.out.println("Number of the rows in people.csv: " + peopleNumInFile);

		int peopleNumInMemory = exerciseService.userRelationships.size();
		System.out.println("Number of the loaded people in memory: " + peopleNumInMemory);

		System.out.println(
				"Have loaded the expected number of people: " + (peopleNumInFile == peopleNumInMemory ? "yes" : "no"));
		System.out.println("****************************Exercise 2 ended *********************************");
		System.out.println();
	}

	/**
	 * Exercise 3: Validate correct relationships loaded
	 */
	@Test
	public void exercise3Test() {

		// Loading data and initial beans
		exercise1Test();
		System.out.println();
		System.out.println("****************************Exercise 3 begins *********************************");
		Map<String, User> users = exerciseService.userRelationships;
		User user = users.get("Bob");
		System.out.println("Bob (" + user.getRelationships().size() + " relationships)");
		user = users.get("Jenny");
		System.out.println("Jenny (" + user.getRelationships().size() + " relationships)");
		user = users.get("Nigel");
		System.out.println("Nigel (" + user.getRelationships().size() + " relationships)");
		user = users.get("Alan");
		System.out.println("Alan (" + user.getRelationships().size() + " relationships)");

		System.out.println("****************************Exercise 3 ended *********************************");
		System.out.println();
	}

	/**
	 * Exercise 4: Write a method that calculates the size of the extended family
	 */
	@Test
	public void exercise4Test() {
		// Loading data and initial beans
		exercise1Test();
		System.out.println();
		System.out.println("****************************Exercise 4 begins *********************************");

		int familyMemCount = exerciseService.getExtendFamilyMemberNum("Jenny") + 1;
		System.out.println("Jenny (" + familyMemCount + " family members)");

		familyMemCount = exerciseService.getExtendFamilyMemberNum("Bob") + 1;
		System.out.println("Bob (" + familyMemCount + " family members)");

		System.out.println("****************************Exercise 4 ended *********************************");
		System.out.println();
	}
}
