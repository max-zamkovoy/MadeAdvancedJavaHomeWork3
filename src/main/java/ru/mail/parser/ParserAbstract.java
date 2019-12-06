package ru.mail.parser;

public abstract class ParserAbstract implements Parser {

    void appendWrapped(String s, String startsWith, String endsWith, StringBuilder stringBuilder) {
        stringBuilder.append(startsWith)
                .append(s)
                .append(endsWith);
    }
}
