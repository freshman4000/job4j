package ru.job4j.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(new File(source).getParent() + "\\" + target))) {
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
                        out.write(sb.toString());
                        sb.setLength(0);
                        flag = false;
                    }
                    if (!br.ready() && flag) {
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        sb.append(";").append(sdf.format(cal.getTime())).append(System.lineSeparator());
                        System.out.println(sb);
                        out.write(sb.toString());
                        sb.setLength(0);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
