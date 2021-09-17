package org.test.aladdin.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.net.URLEncoder;

public class AladdinOpenAPI {
	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";

	public static String GetUrl() throws Exception {
		
		String searchWord = "이동원";
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttbdaback930143001");
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));
		/*
		 * hm.put("QueryType", "Title"); hm.put("MaxResults", "10"); hm.put("start",
		 * "1"); hm.put("SearchTarget", "Book"); hm.put("output", "xml");
		 */

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val  = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}
	
	public List<Item> testMe() throws Exception {
		
		String url = GetUrl();
		AladdinOpenAPIHandler api = new AladdinOpenAPIHandler();
		api.parseXml(url);
		List<Item> list = new ArrayList<>();
		
		list = api.Items;
		
		return list;
		
	}

	public static void main(String[] args) throws Exception {
		String url = GetUrl();
		AladdinOpenAPIHandler api = new AladdinOpenAPIHandler();
		api.parseXml(url);
		for(Item item : api.Items){
			System.out.println(item.Title + " : " + item.Author + " : "+ item.Description);
		}
	}
}