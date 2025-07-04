package JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Serializator {
    public static String Serielaze(Object object) throws IllegalAccessException
    {
        Map<String, Object> CarMap = new HashMap<>();
        Class<?> clas = object.getClass();

        for (Field field : clas.getDeclaredFields()) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);
                String jsonName = jsonField.Name();
                Object value = field.get(object);
                CarMap.put(jsonName, value);
            }
        }

        String jsonBody = CarMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(", "));

        return "{" + jsonBody + "}";
    }
}
