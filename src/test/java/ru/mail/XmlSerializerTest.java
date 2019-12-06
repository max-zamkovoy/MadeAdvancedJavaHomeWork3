package ru.mail;

import org.junit.Test;
import ru.mail.entity.*;
import ru.mail.parser.XmlParser;
import ru.mail.serializer.MadeSerializer;
import ru.mail.serializer.Serializer;

import static org.junit.Assert.assertEquals;

public class XmlSerializerTest {

    Serializer xml = new MadeSerializer(new XmlParser());

    @Test
    public void testSimple() {
        String result = "<EntityOne><fieldOne>1</fieldOne><fieldTwo>2.0</fieldTwo></EntityOne>";
        assertEquals(result, xml.serialize(new EntityOne()));
    }
    @Test
    public void testSimple2() {
        String result = "<EntityTwo><fields><1>1</1><2>2</2><3>3</3></fields></EntityTwo>";
        assertEquals(result, xml.serialize(new EntityTwo()));
    }

    @Test
    public void testSimple3() {
        String result = "<EntityThree><fields><1>1</1><2>2</2><3>3</3></fields></EntityThree>";
        assertEquals(result, xml.serialize(new EntityThree()));
    }

    @Test
    public void testSimple4() {
        String result = "<EntityFour><entityOne><fieldOne>1</fieldOne><fieldTwo>2.0</fieldTwo></entityOne></EntityFour>";
        assertEquals(result, xml.serialize(new EntityFour()));
    }

    @Test
    public void testSimple5() {
        String result = "<EntityFive><fields><fields><1>1</1><2>2</2><3>3</3></fields></fields></EntityFive>";
        assertEquals(result, xml.serialize(new EntityFive()));
    }
}
