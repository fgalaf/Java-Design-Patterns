package sk.fgalaf.dp;

import lombok.Getter;

public class Singleton {
    private static volatile Singleton instance;

    @Getter
    private final String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String type) {
        Singleton result = instance;

        if (result != null) {
            return result;
        }

        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(type);
            }
            return instance;
        }
    }
}
