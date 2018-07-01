package fileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class JsonFileReader {
	
	
	private List<SearchJsonData> searchData;
	
	public JsonFileReader()
	{
		searchData = getJsonData();
	}
	
	private List<SearchJsonData> getJsonData()
	{
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\SearchJsonData.json"));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		SearchJsonData[] fromJson = gson.fromJson(br,SearchJsonData[].class);
		
		List<SearchJsonData> asList = Arrays.asList(fromJson);
		
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asList;
		
	}
	
	public String getSearchData(String name)
	{
		for (SearchJsonData searchJsonData : searchData)
		{
			if (searchJsonData.name.equals(name))
				{
				return searchJsonData.searchText;
				}
		}
		return null;
	}

}
