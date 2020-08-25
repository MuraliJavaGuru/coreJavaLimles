package pushpaFileCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class GetProps {

	private static final String LOGS_PATH = "C:\\Project\\TB_Status.txt";
	private static final String LOG_FILE_NAME = "logs.log";
	private static final String INI_FILE_LOCATION = "C:\\Project\\test.ini";
	private static final String FOLDER_TO_SERACH = "C:\\Project\\";
	static Logger logger = Logger.getLogger(GetProps.class.getName());
	private static boolean isFolderMissing = false;

	private static Map<String,String> errorMap= new HashMap<>();
	private static Map<String, String> map = new HashMap<String, String>();
	
	static {
		System.setProperty("logfilename", LOG_FILE_NAME);
		PropertyConfigurator.configure("log4j.properties");

		errorMap.put("PRJ_BSWTOOLSET_VERSION", "TB_Scripts_error_003");
		errorMap.put("PRJ_BUILD_VERSION", "TB_Scripts_error_004");
		errorMap.put("PRJ_WORKBENCH_VERSION", "TB_Scripts_error_005");
		errorMap.put("PRJ_SWSH_VERSION", "TB_Scripts_error_006");
	}

	public static void main(String[] args) throws Exception {
		logger.debug("Main method started");
		InputStream input = null;
		try {
			checkFileExist(INI_FILE_LOCATION);
			checkFileExist(FOLDER_TO_SERACH);
			input = new FileInputStream(INI_FILE_LOCATION);
			Properties prop = new Properties();
			prop.load(input);
			populateProps(prop);
			for (Entry<String, String> entry : map.entrySet()) {
				String nameFolder = prop.getProperty(entry.getKey());
				String versionFolder = prop.getProperty(entry.getValue());
				boolean folderExists = isFolderExists(entry, nameFolder, versionFolder);
				if (folderExists) {
					checkFileExist(FOLDER_TO_SERACH + nameFolder);
					checkFileExist(entry.getValue(),FOLDER_TO_SERACH + nameFolder + "\\" + versionFolder);
				}
			}
		} catch (FileNotFoundException ex) {
			logger.error("FileNotFoundException occured due to " + ex.getMessage());
			System.out.println(ex.getMessage());
			isFolderMissing = true;
		} catch (IOException ex) {
			logger.error("IO exception occured while parsing from ini file.");
			System.out.println("IO exception occured.please check the logs");
			isFolderMissing = true;
		} finally {
			if (input != null)
				input.close();
			logger.debug("Main method closed.");
		}

		if (!isFolderMissing) {
			System.out.println("*********All folders are available.*****************");
			logger.error("Sucess.All folders are available.");
		}
	}

	private static boolean isFolderExists(Entry<String, String> entry, String nameFolder, String versionFolder) {
		if (nameFolder == null || nameFolder.equals("")) {
			logger.error("The entry " + entry.getKey() + " is not found in the ini file.");
			isFolderMissing = true;
			return false;
		}
		if (versionFolder == null || versionFolder.equals("")) {
			logger.error("The entry " + entry.getValue() + " is not found in the ini file.");
			isFolderMissing = true;
			return false;
		}
		return true;
	}

	private static void populateProps(Properties prop) {
		Set<Object> keys = prop.keySet();
		for (Object k : keys) {
			String key = (String) k;
			String entryName = getStr(key, "_NAME");
			if (entryName != null) {
				String entryVersion = getEntryVersion(prop, entryName);
				if (entryVersion != null) {
					map.put(key, entryVersion);
				}
			}
		}
		System.out.println(map);
	}

	private static String getEntryVersion(Properties prop, String entry) {
		Set<Object> keys = prop.keySet();
		for (Object k : keys) {
			String key = (String) k;
			if (entry.equals(getStr(key, "_VERSION"))) {
				return key;
			}
		}
		return null;
	}

	private static void checkFileExist(String folderToSerach) {
		File f = new File(folderToSerach);
		if (!f.exists()) {
			logger.error("The folder " + folderToSerach + " doesnot exists. ");
			isFolderMissing = true;
		}
	}
	
	private static void checkFileExist(String versionName, String folderToSerach) throws IOException {
		File f = new File(folderToSerach);
		if (!f.exists()) {
			logger.error("The folder " + folderToSerach + " doesnot exists. ");
			isFolderMissing = true;
			checkLogs(versionName);
		}
	}

	private static String getStr(String input, String suffix) {
		String out = null;
		if (input.endsWith(suffix)) {
			out = input.substring(0, input.length() - suffix.length());
		}
		return out;
	}

	public static void checkLogs(String searchFor) throws IOException {
		File file = new File(LOGS_PATH);
		String search = errorMap.get(searchFor);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		boolean found=false;
		while ((st = br.readLine()) != null) {
			if(st.contains(search)) {
				found=true;
				break;
			}
		}
		if(!found)
			logger.error("ERROR Code "+search+"is Missing in "+LOGS_PATH);
		br.close();
	}
}