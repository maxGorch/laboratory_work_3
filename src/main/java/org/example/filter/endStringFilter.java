package org.example.filter;

public class endStringFilter implements Filter
//Проверка, что строка заканчивается на определенную подстроку.
{
    private final String pattern;

    public endStringFilter(String pattern) {
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
        return str.endsWith(pattern);
    }
}

