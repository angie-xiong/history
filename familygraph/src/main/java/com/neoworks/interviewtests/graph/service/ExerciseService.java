package com.neoworks.interviewtests.graph.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.neoworks.interviewtests.graph.constant.Constants;
import com.neoworks.interviewtests.graph.entity.Relationship;
import com.neoworks.interviewtests.graph.entity.User;
import com.neoworks.interviewtests.graph.utils.FileReaderUtils;

/**
 * This class offers services for exercises.
 * 
 * @author Angie.xiong
 *
 */
public class ExerciseService {

	// #Purpose 1: An in-memory only solution, no use of databases or persistence.
	// Solution 1: I use a Map to reserve data which have been read.

	public Map<String, List<String[]>> loadedOriginalData = new HashMap<String, List<String[]>>(); // key: file name,
																									// value: rows

	public Map<String, User> userRelationships = new HashMap<String, User>(); // key: user name, value: user information
																				// and relationships with other people

	public void loadData() {
		FileReaderUtils frUtils = new FileReaderUtils();

		// Get the project's root absolute path.
		File desDir = new File(frUtils.getPath());
		if (desDir.exists() && desDir.isDirectory()) {
			System.out.println("File path: " + frUtils.getPath());

			// Get files in under the indicated path.
			File[] files = desDir.listFiles();
			if (files != null && files.length > 0) {

				// Read files in this loop.
				for (File file : files) {

					System.out.println("-------------File name : " + file.getName() + "-----------------");
					List<String[]> list = frUtils.readFile(file);

					// Reserve the loaded data into in-memory
					loadedOriginalData.put(file.getName(), list);
				}
				System.out.println(loadedOriginalData.size());
			}
		}
	}

	public void createBeans(Map<String, Class<?>> connections) {
		if (null != loadedOriginalData && loadedOriginalData.size() > 0) {
			Map<String, User> users = null;
			List<Relationship> relationships = null;
			for (Entry<String, List<String[]>> entry : loadedOriginalData.entrySet()) {
				if (connections.get(entry.getKey()).equals(User.class)) {
					users = constructUsers(entry.getValue());
				} else if (connections.get(entry.getKey()).equals(Relationship.class)) {
					relationships = constructRelationships(entry.getValue());
				}
			}

			System.out.println("users.size() = " + users.size());
			System.out.println("relationships.size() = " + relationships.size());
			System.out.println();
			buildUpConnections(users, relationships);
		}
	}

	private List<Relationship> constructRelationships(List<String[]> records) {
		if (CollectionUtils.isNotEmpty(records)) {
			List<Relationship> relationships = new ArrayList<Relationship>(records.size());
			Relationship relationship = null;
			for (String[] cells : records) {
				relationship = new Relationship();
				if (cells.length == Constants.CSV_RELATIONSHIP_COLUMN_NUM) {
					if (StringUtils.isNotBlank(cells[0]) && StringUtils.isNotBlank(cells[1])
							&& StringUtils.isNotBlank(cells[2])) {
						relationship.setPrimaryEmail(cells[0]);
						relationship
								.setRelationshipType(Constants.RELATIONSHIPTYPE_FAMILY_SYMBOL.equalsIgnoreCase(cells[1])
										? Constants.RELATIONSHIPTYPE_FAMILY
										: Constants.RELATIONSHIPTYPE_FRIEND);
						relationship.setEmail(cells[2]);

						// Add people's relationships into a list.
						relationships.add(relationship);
					}
				} else {
					continue;
				}
			}
			return relationships;
		}
		return null;
	}

	private Map<String, User> constructUsers(List<String[]> records) {
		if (CollectionUtils.isNotEmpty(records)) {
			Map<String, User> users = new HashMap<String, User>(records.size());
			User user = null;
			for (String[] cells : records) {
				user = new User();
				if (cells.length == Constants.CSV_PEOPLE_COLUMN_NUM) {
					if (StringUtils.isNotBlank(cells[0]) && StringUtils.isNotBlank(cells[1])
							&& StringUtils.isNotBlank(cells[2])) {
						user.setUserName(cells[0]);
						user.setEmail(cells[1]);
						user.setAge(Integer.valueOf(cells[2]));

						// Set people's email as the map's key.The map's value is the user's
						// information.
						users.put(cells[1], user);
					}
				} else {
					continue;
				}
			}
			return users;
		}
		return null;
	}

	public void buildUpConnections(Map<String, User> users, List<Relationship> relationships) {

		if (!users.isEmpty() && CollectionUtils.isNotEmpty(relationships)) {
			User user = null;
			for (Entry<String, User> entry : users.entrySet()) {

				List<Relationship> relationshipList = new ArrayList<Relationship>();
				List<Relationship> familyMembers = new ArrayList<Relationship>();
				List<Relationship> friends = new ArrayList<Relationship>();
				for (Relationship relationship : relationships) {
					user = entry.getValue();

					if (relationship.getPrimaryEmail().equals(user.getEmail())
							|| relationship.getEmail().equals(user.getEmail())) {
						relationshipList.add(relationship);
						if (Constants.RELATIONSHIPTYPE_FRIEND.equals(relationship.getRelationshipType())) {
							friends.add(relationship);
						} else {
							familyMembers.add(relationship);
						}
					} else {
						continue;
					}
				}
				user.setRelationships(relationshipList);
				user.setFamilyMembers(familyMembers);
				user.setFriends(friends);
				userRelationships.put(user.getUserName(), user);

				System.out.print("User's name is " + user.getUserName() + ", number of his connctions: "
						+ relationshipList.size());
				System.out.print(", number of his family members : " + familyMembers.size());
				System.out.println(", number of his friends : " + friends.size());
			}
		} else {
			System.out.println("There is no datum to be structurized");
		}
	}

	public int getExtendFamilyMemberNum(String userName) {
		User user = userRelationships.get(userName);
		int count = 0;
		if (CollectionUtils.isNotEmpty(user.getRelationships())) {
			for (Relationship relationship : user.getRelationships()) {
				if (Constants.RELATIONSHIPTYPE_FAMILY.equals(relationship.getRelationshipType())) {
					count++;
				}
			}
		}
		return count;
	}
}
