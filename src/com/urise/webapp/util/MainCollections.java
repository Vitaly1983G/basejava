package com.urise.webapp.util;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "1";
    private static final String UUID_2 = "2";
    private static final String UUID_3 = "3";
    private static final String UUID_4 = "4";

    private static final Resume resume1 = new Resume(UUID_1, "fullName");
    private static final Resume resume2 = new Resume(UUID_2, "fullName");
    private static final Resume resume3 = new Resume(UUID_3, "fullName");
    private static final Resume resume4 = new Resume(UUID_4, "fullName");

    public static void main(String... args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(resume1);
        collection.add(resume2);
        collection.add(resume3);
//        for (Resume r : collection) {
//            System.out.println(r);
//        }
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, resume1);
        map.put(UUID_2, resume2);
        map.put(UUID_3, resume3);

        for (String UUID_1 : map.keySet()) {
            System.out.println(map.get(UUID_1));
        }
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}