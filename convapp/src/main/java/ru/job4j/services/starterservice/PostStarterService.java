package ru.job4j.services.starterservice;

import ru.job4j.services.inputservices.ArgsInputService;
import ru.job4j.services.inputservices.UserInputService;
import ru.job4j.services.outputservices.TxtFileOutPutter;
import ru.job4j.services.conversionservices.TxtFileToMapConversionService;
import ru.job4j.services.inputservices.InputService;

import java.io.FileNotFoundException;

/**
 * Starting service object, that has overloaded start() method. If incoming parameters present,
 * instance of this class will use method with parameters, if - not, - without.
 */
public class PostStarterService implements StarterService<String[]> {
    private InputService<String[]> inputService;

    @Override
    public void start() throws FileNotFoundException {
        inputService = new UserInputService();
        String[] in = inputService.getInput();
        new TxtFileOutPutter(new TxtFileToMapConversionService(in[0]).convert(), in[1]).createOutput();
    }

    @Override
    public void start(String[] item) throws FileNotFoundException {
        inputService = new ArgsInputService(item);
        String[] in = inputService.getInput();
        new TxtFileOutPutter(new TxtFileToMapConversionService(in[0]).convert(), in[1]).createOutput();
    }
}