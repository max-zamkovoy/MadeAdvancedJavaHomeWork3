package ru.mail.parser;

public class JsonParser extends ParserAbstract {

    @Override
    public void startRootObject(Object object, StringBuilder stringBuilder) {
    }

    @Override
    public void endRootObject(Object object, StringBuilder stringBuilder) {
    }

    @Override
    public void startObject(StringBuilder stringBuilder) {
        stringBuilder.append("{");
    }

    @Override
    public void endObject(StringBuilder stringBuilder) {
        stringBuilder.append("}");
    }

    @Override
    public void startObjectKey(String key, StringBuilder stringBuilder, int index, int size) {
        if (index > 0) {
            stringBuilder.append(",");
        }
        addQuoted(key, stringBuilder);
        stringBuilder.append(":");
    }

    @Override
    public void endObjectKey(String key, StringBuilder stringBuilder, int index, int size) {
    }

    @Override
    public void addObjectValue(String value, StringBuilder stringBuilder, int index, int size) {
        addQuoted(value, stringBuilder);
    }

    @Override
    public void addArrayValue(String value, StringBuilder stringBuilder, int index, int size) {
        if (index > 0) {
            stringBuilder.append(",");
        }
        addQuoted(value, stringBuilder);
    }

    @Override
    public void addArraySeparateItem(String value, StringBuilder stringBuilder, int index, int size) {
        if (index < size) {
            stringBuilder.append(",");
        }
    }

    @Override
    public void startArray(StringBuilder stringBuilder) {
        stringBuilder.append("[");
    }

    @Override
    public void endArray(StringBuilder stringBuilder) {
        stringBuilder.append("]");
    }

    private void addQuoted(String s, StringBuilder stringBuilder) {
        appendWrapped(s, "\"", "\"", stringBuilder);
    }
}
