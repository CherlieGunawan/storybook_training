package id.co.nds.storybook.validators;

import java.util.NoSuchElementException;

public class ObjectValidator {
    public void nullCheckObject(Object o) throws NoSuchElementException {
        if(o == null) {
            throw new NoSuchElementException("Data not found");
        }
    }
}
