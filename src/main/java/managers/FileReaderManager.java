package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonDataReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager=new FileReaderManager();
	private static ConfigFileReader configFileReader=new ConfigFileReader();
	private static JsonDataReader jsonDataReader;
	private FileReaderManager() {}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
		
	}
	
	public ConfigFileReader getConfigReader() {
		return (configFileReader==null)?configFileReader=new ConfigFileReader():configFileReader;
	}
	
	 public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
		 }

}
