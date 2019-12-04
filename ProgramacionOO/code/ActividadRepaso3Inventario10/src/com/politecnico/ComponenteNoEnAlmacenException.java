package com.politecnico;

import java.util.NoSuchElementException;

public class ComponenteNoEnAlmacenException extends NoSuchElementException {
    public ComponenteNoEnAlmacenException(String msg){
        super(msg);
    }
}
