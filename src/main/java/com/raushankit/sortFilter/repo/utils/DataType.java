package com.raushankit.sortFilter.repo.utils;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("unused")
public class DataType {

    private static final Set<Class<?>> numberClasses = Set.of(
            int.class, long.class, float.class,
            double.class, byte.class, short.class);

    private static final Set<Class<?>> stringClasses = Set.of(
            char.class, String.class, Character.class
    );

    private static final Set<Class<?>> dateClasses = Set.of(
            LocalDate.class, LocalDateTime.class,
            Date.class, Timestamp.class, Time.class
    );

    public static boolean isStringType(Class<?> cls) {
        return stringClasses.contains(cls);
    }

    public static final String NUMBER = "number";

    public static final String STRING = "string";

    static class DATE_TIME {
        public static final String LOCAL_DATE_TIME = "local-date-time";
        public static final String LOCAL_DATE = "local-date";
        public static final String SQL_DATE = "sql-date";
        public static final String SQL_TIME = "sql-time";
        public static final String SQL_TIMESTAMP = "sql-timestamp";
        public static final String LONG_TIMESTAMP = "sql-timestamp";
    }
}
