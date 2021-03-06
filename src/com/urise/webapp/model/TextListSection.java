package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextListSection extends AbstractSection implements Serializable {
    private  List<String> ListSection;

    public TextListSection() {
    }

    public TextListSection(String... lines) {
        this(Arrays.asList(lines));
    }

    public TextListSection(List<String> listSection) {
        Objects.requireNonNull(listSection, "listSection required non null");
        ListSection = listSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextListSection that = (TextListSection) o;
        return ListSection.equals(that.ListSection);
    }

    @Override
    public int hashCode() {
        return ListSection.hashCode();
    }

    public List<String> getListSection() {
        return ListSection;
    }
}