package ru.mail.parser;

public interface Parser {

    void startRootObject(Object object, StringBuilder stringBuilder);

    void endRootObject(Object object, StringBuilder stringBuilder);

    void startObject(StringBuilder stringBuilder);

    void endObject(StringBuilder stringBuilder);

    void startObjectKey(String key, StringBuilder stringBuilder, int index, int size);

    void endObjectKey(String key, StringBuilder stringBuilder, int index, int size);

    void addObjectValue(String value, StringBuilder stringBuilder, int index, int size);

    void addArrayValue(String value, StringBuilder stringBuilder, int index, int size);

    void addArraySeparateItem(String value, StringBuilder stringBuilder, int index, int size);

    void startArray(StringBuilder stringBuilder);

    void endArray(StringBuilder stringBuilder);
}
