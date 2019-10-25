package ru.job4j.services.conversionservices;

import java.io.FileNotFoundException;

/**
 * Interface, responsible for data conversion.
 * @param <T> output type parameter.
 */
public interface ConversionService<T> {
    T convert() throws FileNotFoundException;
}
