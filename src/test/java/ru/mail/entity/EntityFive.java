package ru.mail.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityFive {

    private List<EntityThree> fields = new ArrayList<>();

    public EntityFive() {
        fields.add(new EntityThree());
    }
}
