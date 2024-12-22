package org.example.filter;

public class beginStringFilter implements Filter {
    private final String pattern;

    public beginStringFilter(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Строчка не может быть null!");
        }
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(pattern);
    }
}
