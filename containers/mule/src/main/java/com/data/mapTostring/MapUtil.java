/**
 * 
 */
package com.data.mapTostring;

/**
 * @author BGRANTHAM
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class MapUtil implements Callable {
	public static String mapToString(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder();

		for (String key : map.keySet()) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			Object value;
			try {
				value = map.get(key);
			} catch (NullPointerException ne) {
				value = "";
				throw new RuntimeException(
						"Key value is null. Cannot populate the buffer with null.");
			}
			try {
//				sb.append((key != null ? key: ""));
//				sb.append("=");
				sb.append(value != null ? value : "");
			} catch (Exception e) {
				throw new RuntimeException(
						"Bad value passed into stringbuiler", e);
			}
		}
		sb.setCharAt(sb.lastIndexOf(","), ' ');
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}

	public static Map<String, String> stringToMap(String input) {
		Map<String, String> map = new HashMap<String, String>();

		String[] nameValuePairs = input.split("&");
		for (String nameValuePair : nameValuePairs) {
			String[] nameValue = nameValuePair.split("=");
			try {
				map.put(URLDecoder.decode(nameValue[0], "UTF-8"),
						nameValue.length > 1 ? URLDecoder.decode(nameValue[1],
								"UTF-8") : "");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"This method requires UTF-8 encoding support", e);
			}
		}

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mule.api.lifecycle.Callable#onCall(org.mule.api.MuleEventContext)
	 */
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> resultMap = (Map<String, String>) eventContext
		.getMessage().getPayload();
//		if(eventContext.getMessage().getInvocationProperty("counter", PropertyScope.INVOCATION).equals("1")){
//			
//		}
//		Map<String, String> resultMap = (Map<String, String>) eventContext
//				.getMessage().getPayload();
		String results = mapToString(resultMap);
		return results;
	}
}
