package com.neoworks.interviewtests.graph.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.neoworks.interviewtests.graph.constant.Constants;
import com.opencsv.CSVReader;

public class FileReaderUtils {

	public String getPath() {
		try {
			// Get project's run-time root path
			String rootFile = new File("").getCanonicalPath();
			String path = rootFile + Constants.FILE_LOCATION;
			return path;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * #Purpose 4: Use of libraries and utility methods to save time and code.
	 * Solution 4: I use CSVReader to read the csv files here.
	 * @param file
	 * @return
	 */
	public List<String[]> readFile(File file) {
		CSVReader csvReader = null;
		try {
			if (file != null) {
				FileReader fReader = new FileReader(file);
				csvReader = new CSVReader(fReader);
				return csvReader.readAll();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
