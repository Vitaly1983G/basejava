package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public interface Storage {

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();
    // Create copy of resumes without 'null'

    int size();

    void update(Resume resume);
}