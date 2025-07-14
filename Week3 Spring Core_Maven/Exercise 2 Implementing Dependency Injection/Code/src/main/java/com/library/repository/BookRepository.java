package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public List<String> getBookList() {
        return Arrays.asList("1984", "Brave New World", "Fahrenheit 451");
    }
}