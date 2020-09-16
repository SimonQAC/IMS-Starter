package com.qa.ims.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtils extends Utils {

	private static final Logger LOGGER = LogManager.getLogger();

	private final String DB_USER;

	private final String DB_PASS;

	//gcp login currently not working
	//private final String DB_URL = "jdbc:mysql://34.105.237.235/ims-speppitt:europe-west2:ims-db?db_name&serverTimezone=UTC";
	//localhost login
	private final String DB_URL = "jdbc:mysql://localhost:3306/ims?db_name&serverTimezone=UTC";

	private DBUtils(String username, String password) {
		this.DB_USER = username;
		this.DB_PASS = password;

		init();
	}

	public int init() {
		return this.init("src/main/resources/sql-schema.sql", "src/main/resources/sql-data.sql");
	}

	public int init(String... paths) {
		int modified = 0;

		for (String path : paths) {
			modified += executeSQLFile(path);
		}

		return modified;
	}

	public int executeSQLFile(String file) {
		int modified = 0;
		try (Connection connection = this.getConnection();
				BufferedReader br = new BufferedReader(new FileReader(file));) {
			String fileAsString = br.lines().reduce((acc, next) -> acc + next).orElse("");
			String[] queries = fileAsString.split(";");
			modified += Stream.of(queries).map(string -> {
				try (Statement statement = connection.createStatement();) {
					return statement.executeUpdate(string);
				} catch (Exception e) {
					LOGGER.debug(e);
					return 0;
				}
			}).reduce((acc, next) -> acc + next).orElse(0);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return modified;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public static DBUtils instance;

	public static DBUtils connect(String username, String password) {
		instance = new DBUtils(username, password);
		return instance;
	}

	public static DBUtils getInstance() {
		if (instance == null) {
			instance = new DBUtils("", "");
		}
		return instance;
	}
	
	public static String getLogin() {
		LOGGER.info("Please enter database username:");
		Utils u = new Utils();
		String user = u.getString();
		return user;
	}
	
	public static String getPassword() {
		LOGGER.info("Please enter database password:");
		Utils p = new Utils();
		String password = p.getString();
		return password;
	}

}