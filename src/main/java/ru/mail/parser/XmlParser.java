package ru.mail.parser;

public class XmlParser extends ParserAbstract {

    @Override
    public void startRootObject(Object object, StringBuilder stringBuilder) {
        addOpenTag(object.getClass().getSimpleName(), stringBuilder);
    }

    @Override
    public void endRootObject(Object object, StringBuilder stringBuilder) {
        addCloseTag(object.getClass().getSimpleName(), stringBuilder);
    }

    @Override
    public void startObject(StringBuilder stringBuilder) {
    }

    @Override
    public void endObject(StringBuilder stringBuilder) {
    }

    @Override
    public void startObjectKey(String key, StringBuilder stringBuilder, int index, int size) {
        addOpenTag(key, stringBuilder);
    }

    @Override
    public void endObjectKey(String key, StringBuilder stringBuilder, int index, int size) {
        addCloseTag(key, stringBuilder);
    }

    @Override
    public void addObjectValue(String value, StringBuilder stringBuilder, int index, int size) {
        stringBuilder.append(value);
    }

    @Override
    public void addArrayValue(String value, StringBuilder stringBuilder, int index, int size) {
        String tag = String.valueOf(index + 1);
        addOpenTag(tag, stringBuilder);
        stringBuilder.append(value);
        addCloseTag(tag, stringBuilder);
    }

    @Override
    public void addArraySeparateItem(String value, StringBuilder stringBuilder, int index, int size) {
    }

    @Override
    public void startArray(StringBuilder stringBuilder) {
    }

    @Override
    public void endArray(StringBuilder stringBuilder) {
    }

    private void addCloseTag(String name, StringBuilder stringBuilder) {
        appendWrapped(name, "</", ">", stringBuilder);
    }

    private void addOpenTag(String name, StringBuilder stringBuilder) {
        appendWrapped(name, "<", ">", stringBuilder);
    }
}
