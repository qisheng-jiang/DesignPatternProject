package Visitor;

import Filter.Field;

public class FieldVisitor implements BaseVisitor {
    @Override
    public void visit(Field field) {
        System.out.println("This field's ID is "+field.getId()+" and the moisture is "+field.getMoisture());
    }
}
