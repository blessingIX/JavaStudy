package com.yzj.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: yzj
 * @create: 2020-11-21 17:04
 */
public class ReadOnlyCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);
    }
}
