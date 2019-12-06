package ru.mail.serializer;

import ru.mail.parser.Parser;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class MadeSerializer implements Serializer {

    private Parser parser;

    public MadeSerializer(Parser parser) {
        this.parser = parser;
    }

    @Override
    public String serialize(Object root) {
        StringBuilder stringBuilder = new StringBuilder();
        parser.startRootObject(root, stringBuilder);
        try {
            parseObject(root, stringBuilder);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        parser.endRootObject(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void parseObject(Object object, StringBuilder stringBuilder) throws IllegalAccessException {
        parser.startObject(stringBuilder);
        Field[] fields = object.getClass().getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(object);
            parser.startObjectKey(fieldName, stringBuilder, i, fields.length);
            if (isPrimitive(field.getType())) {
                parser.addObjectValue(value.toString(), stringBuilder, i, fields.length);
            } else {
                parseItem(value, stringBuilder);
            }
            parser.endObjectKey(fieldName, stringBuilder, i, fields.length);
            i++;
        }
        parser.endObject(stringBuilder);
    }

    private void parseCollection(Object object, StringBuilder stringBuilder) throws IllegalAccessException {
        parser.startArray(stringBuilder);
        Collection collection;
        if (object.getClass().isArray()) {
            collection = Arrays.asList((Object[]) object);
        } else {
            collection = (Collection)object;
        }
        int i = 0;
        for (Object item : collection) {
            if (isPrimitive(item.getClass())) {
                parser.addArrayValue(item.toString(), stringBuilder, i, collection.size());
            } else {
                parseItem(item, stringBuilder);
                parser.addArraySeparateItem(item.toString(), stringBuilder, i, collection.size());
            }
            i++;
        }
        parser.endArray(stringBuilder);
    }

    private void parseItem(Object object, StringBuilder stringBuilder) throws IllegalAccessException {
        if (isCollection(object)) {
            parseCollection(object, stringBuilder);
        } else {
            parseObject(object, stringBuilder);
        }
    }

    public boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive() || clazz.equals(String.class);
    }

    private boolean isCollection(Object object) {
        return object.getClass().isArray() || object instanceof Collection;
    }
}
