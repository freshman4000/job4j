package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

class Search {
    public Search() {
        System.setProperty("java.io.tmpdir", "src/main/resources/tmp/");
    }

    public List<File> files(String parent, List<String> exts) {

        List<File> result = new LinkedList<>();
        Queue<File> list = new LinkedList<>();
        if (parent != null) {
            list.offer(new File(parent));
            while (!list.isEmpty()) {
                File buff = list.poll();
                if (buff.isDirectory()) {
                    Arrays.stream(buff.listFiles())
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList()).forEach(list::offer);
                } else {
                    for (String s : exts) {
                        if (buff.getName().endsWith(s)) {
                            result.add(buff);
                        }
                    }
                }
            }
        }
        return result;
    }
}
