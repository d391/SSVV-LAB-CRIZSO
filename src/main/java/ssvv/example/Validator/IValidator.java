package ssvv.example.Validator;

import ssvv.example.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}