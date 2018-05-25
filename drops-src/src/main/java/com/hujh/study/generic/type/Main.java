package com.hujh.study.generic.type;

import java.io.IOException;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.type.TypeReference;


public class Main {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Map<Long, StudentEntity> map = new HashMap<>();
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(1L);
		studentEntity.setName("hujh");
		map.put(studentEntity.getId(), studentEntity);
		
		StdSerializerProvider sp = new StdSerializerProvider();
		sp.setNullValueSerializer(new NullSerializer());
		ObjectMapper objectMapper = new ObjectMapper(null, sp, null);
		//允许json比对象多字段
		objectMapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setDateFormat(DateFormat.getDateTimeInstance());// 设置自己的格式
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,
				true);
		
		
		String json = objectMapper.writeValueAsString(map);
		// Map<Long, StudentEntity> jsonToMap = objectMapper.readValue(json, Map.class);
		Map<Long, StudentEntity> jsonToMap = objectMapper.readValue(json, new TypeReference<Map<Long, StudentEntity>>(){} );
		
		System.out.println(jsonToMap);
	}

}
