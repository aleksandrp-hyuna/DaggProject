package com.example.vlad.daggproject.testutils;

import com.example.vlad.daggproject.model.AdapterFactory;
import com.example.vlad.daggproject.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;

/**
 * Created by Vladyslav on 08.12.2017
 */

public class TestUtils {

    private static final TestUtils INSTANCE = new TestUtils();

    private static final Moshi TEST_MOSHI = initializeMoshi();

    private TestUtils() {}

    public static <T> T loadJson(String path, Type type, Class<T> clazz) {
        try {
            String json = getFileString(clazz, path);
            //noinspection unchecked
            return (T) TEST_MOSHI.adapter(type).fromJson(json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize: " + path + "into type: " + type);
        }
    }

    public static <T> T loadJson(String path, Class<T> clazz) {
        try {
            String json = getFileString(clazz, path);
            //noinspection unchecked
            return (T) TEST_MOSHI.adapter(clazz).fromJson(json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize: " + path + "into class: " + clazz);
        }
    }

    static InputStream getStringFromFile(Class clazz, String fileName) throws IOException {
        URL resource = clazz.getClassLoader().getResource(fileName);
        return resource.openStream();
    }

    private static String getFileString(Class clazz, String path) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(getStringFromFile(clazz, path)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read from resuorce at: " + path);
        }
    }

    private static Moshi initializeMoshi() {
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZonedDateTimeAdapter())
                .build();
    }
}
