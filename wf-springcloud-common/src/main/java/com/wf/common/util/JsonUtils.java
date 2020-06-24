package com.wf.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json 转换工具类
 * @Author ：wf
 * @Date ：2020/6/24 9:38
 * @Describe：
 */
public class JsonUtils {
    private static final MapType MAP_TYPE = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class);
    private static final CollectionType LIST_TYPE;
    private static ObjectMapper defaultMapper;

    private JsonUtils() {
    }

    public static void toOutput(OutputStream out, Object object) {
        if (object != null) {
            try {
                defaultMapper.writeValue(out, object);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    public static String toText(Object object) {
        if (object == null) {
            return null;
        } else {
            try {
                return defaultMapper.writeValueAsString(object);
            } catch (JsonProcessingException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static <T> T toObject(String jsonText, Class<T> cls) {
        if (jsonText != null && !jsonText.isEmpty()) {
            try {
                return defaultMapper.readValue(jsonText, cls);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }

    public static Map<String, Object> toMap(String jsonText) {
        if (jsonText != null && !jsonText.isEmpty()) {
            try {
                return (Map)defaultMapper.readValue(jsonText, MAP_TYPE);
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        } else {
            return null;
        }
    }

    public static <T> Map<String, T> toMap(String jsonText, Class<T> cls) {
        if (jsonText != null && !jsonText.isEmpty()) {
            try {
                return (Map)defaultMapper.readValue(jsonText, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, cls));
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }

    public static List<Map<String, Object>> toList(String jsonText) {
        if (jsonText != null && !jsonText.isEmpty()) {
            try {
                return (List)defaultMapper.readValue(jsonText, LIST_TYPE);
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        } else {
            return null;
        }
    }

    public static <T> List<T> toList(String jsonText, Class<T> cls) {
        if (jsonText != null && !jsonText.isEmpty()) {
            try {
                return (List)defaultMapper.readValue(jsonText, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, cls));
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }

    static {
        LIST_TYPE = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, MAP_TYPE);
        defaultMapper = new ObjectMapper();
        defaultMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        defaultMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        defaultMapper.enable(new JsonParser.Feature[]{JsonParser.Feature.ALLOW_MISSING_VALUES});
        defaultMapper.enable(new JsonParser.Feature[]{JsonParser.Feature.ALLOW_SINGLE_QUOTES});
        defaultMapper.enable(new JsonParser.Feature[]{JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES});
    }
}
