package ru.mail;

import org.junit.Test;
import ru.mail.entity.*;
import ru.mail.parser.JsonParser;
import ru.mail.serializer.MadeSerializer;
import ru.mail.serializer.Serializer;

import static org.junit.Assert.*;

public class JsonSerializerTest {

    Serializer json = new MadeSerializer(new JsonParser());

    @Test
    public void testSimple() {
        String result = "{\"fieldOne\":\"1\",\"fieldTwo\":\"2.0\"}";
        assertEquals(result, json.serialize(new EntityOne()));
    }
    @Test
    public void testSimple2() {
        String result = "{\"fields\":[\"1\",\"2\",\"3\"]}";
        assertEquals(result, json.serialize(new EntityTwo()));
    }

    @Test
    public void testSimple3() {
        String result = "{\"fields\":[\"1\",\"2\",\"3\"]}";
        assertEquals(result, json.serialize(new EntityThree()));
    }

    @Test
    public void testSimple4() {
        String result = "{\"entityOne\":{\"fieldOne\":\"1\",\"fieldTwo\":\"2.0\"}}";
        assertEquals(result, json.serialize(new EntityFour()));
    }

    @Test
    public void testSimple5() {
        String result = "{\"fields\":[{\"fields\":[\"1\",\"2\",\"3\"]},]}";
        assertEquals(result, json.serialize(new EntityFive()));
    }
}