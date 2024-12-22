package org.example.filter;

public class containsStringFilter implements Filter
//Проверка, что строка содержит заданную подстроку.
{
    private final String pattern;

    public containsStringFilter(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern cannot be null");
        }
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) {
            return false;
        }
        return str.contains(pattern);
    }
}

