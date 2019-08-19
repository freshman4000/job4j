package ru.job4j.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> result = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder("");
            while (br.ready()) {
                String str = br.readLine();
                if (!str.isBlank()) {
                    String[] buff = str.split(" ");
                    if ((buff[0].equals("400") || buff[0].equals("500")) && !flag) {
                        sb.append(buff[1]);
                        flag = true;
                    }
                    if (!buff[0].equals("400") && !buff[0].equals("500") && flag) {
                        sb.append(";").append(buff[1]).append(System.lineSeparator());
                        result.add(sb.toString());
                        sb.setLength(0);
                        flag = false;
                    }
                    if (!br.ready() && flag) {
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        sb.append(";").append(sdf.format(cal.getTime())).append(System.lineSeparator());
                        result.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        write(result, source, target);
    }

    public void write(List<String> result, String source, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(source).getParent() + "/" + target))) {
            result.forEach(out::write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
