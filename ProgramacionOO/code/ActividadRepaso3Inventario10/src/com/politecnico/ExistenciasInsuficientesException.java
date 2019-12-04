package com.politecnico;

import java.util.NoSuchElementException;

public class ExistenciasInsuficientesException extends NoSuchElementException {
	public ExistenciasInsuficientesException(String msg) {
		super(msg);
	}
}
