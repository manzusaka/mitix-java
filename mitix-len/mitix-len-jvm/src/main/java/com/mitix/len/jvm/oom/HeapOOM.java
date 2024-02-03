package com.mitix.len.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oldflame-jm
 * @since 1.0.0
 *
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
