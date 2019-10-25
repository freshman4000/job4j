package ru.job4j.services.outputservices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Class that prepares output data for output file.
 */
public class TxtFileOutPutter implements OutputService {
    private Map<String, String> data;
    private String filePath;

    public TxtFileOutPutter(Map<String, String> data, String filePath) {
        this.data = data;
        this.filePath = filePath;
    }

    /**
     * This method converts map entry set data to out put file, by
     * mentioning user name and appending to it following corresponded
     * emails.
     */
    @Override
    public void createOutput() {

        File file = new File(filePath);

        StringBuilder sb = new StringBuilder("");

        try (FileWriter fileWriter = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fileWriter)) {

            data.values().stream().distinct().forEach(x -> {

                sb.append(x).append(" ->");

                for (Map.Entry<String, String> entry : data.entrySet()) {

                    if (entry.getValue().equals(x)) {
                        sb.append(entry.getKey()).append(",");
                    }
                }
                pw.print(sb.toString().substring(0, sb.toString().length() - 1) + System.lineSeparator());
                sb.setLength(0);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}