package ru.job4j.io.pack;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> seekBy(String root, String ext) {
        List<File> result = new ArrayList<>();
        if (root != null) {
            Queue<File> q = new LinkedList<>();
            q.offer(new File(root));
            while (!q.isEmpty()) {
                File current = q.poll();
                if (current.isDirectory()) {
                    q.addAll(Stream.of(Objects.requireNonNull(current.listFiles()))
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList()));
                } else {
                    if (!current.getName().endsWith(ext.substring(1))) {
                        result.add(current);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        Args arg = new Args(args);
        zip.pack(zip.seekBy(arg.directory(), arg.exclude()), new File(arg.output()));
    }
}
