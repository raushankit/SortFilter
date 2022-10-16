package com.raushankit.sortFilter.repo.utils;

import javax.persistence.Embeddable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Utility class to trace path of the fields to get
 *     path of the criteriaQuery.
 * </p>
 * @author Raushan, Ankit
 */
@SuppressWarnings({"javadoc", "unused"})
public class FieldPath {

    private final List<Class<? extends Annotation>> embeddableClassList =
            List.of(Embeddable.class);

    /**
     * @param klass: class of the entity to be traced
     * @return: Map of keys with fieldName and value as
     *          path till that field in entity
     */
    public Map<String, List<String>> getTree(Class<?> klass) {
        Map<String, List<String>> mp = new HashMap<>();
        for(Field field: klass.getDeclaredFields()) {
            List<String> paths = new ArrayList<>();
            traverse(paths, field, null);
            paths.stream()
                    .map(path -> path.split(",", -1))
                    .forEach(array -> mp.put(array[array.length - 1], Arrays.asList(array)));
        }
        return mp;
    }

    private void traverse(List<String> list, Field field, String path) {
        Class<?> fieldClass = field.getType();
        final String path1 = (path == null? "": path + ",") + field.getName();
        if(embeddableClassList.stream().anyMatch(fieldClass::isAnnotationPresent)){
            Arrays.stream(fieldClass.getDeclaredFields())
                    .forEach(field1 -> traverse(list, field1, path1));
        } else{
            list.add(path1);
        }
    }

}
