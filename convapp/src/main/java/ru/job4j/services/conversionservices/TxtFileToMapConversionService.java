package ru.job4j.services.conversionservices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class that converts file content to the LinkedHashMap, where key values are emails
 * and value, corresponding to each email, is the first met coupled (to this e-mail) value.
 * If different values are met, corresponding to the same email - they don't override
 * first met value.
 *
 */
public class TxtFileToMapConversionService implements ConversionService<Map<String, String>> {
    private String filePath;

    public TxtFileToMapConversionService(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method takes input by querying single line from the file content
     * transfers it to map entry set.
     * @return map.
     */
    @Override
    public Map<String, String> convert() throws FileNotFoundException {
        Map<String, String> result = new LinkedHashMap<>();

        Scanner sc = new Scanner(new File(filePath));

            while (sc.hasNextLine()) {

                String[] curLIne = sc.nextLine().split(" ->");
                for (String key : curLIne[1].split(",")) {

                    curLIne[0] = result.getOrDefault(key, curLIne[0]);
                    result.put(key, curLIne[0]);
                }
            }
        return result;
    }
}