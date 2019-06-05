package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Items;

public class JsonDataReader {
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Items.json";
	private List<Items> itemList;
	
	public JsonDataReader(){
		itemList = getData();
	}
	
	private List<Items> getData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Items[] items = gson.fromJson(bufferReader, Items[].class);
			return Arrays.asList(items);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Items getName(String name){
			 return itemList.stream().filter(x -> x.item.equalsIgnoreCase(name)).findAny().get();
	}
	
}
