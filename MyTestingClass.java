package org.example;

import java.util.*;

class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    // Custom hashCode implementation
    public int hashCode() {
        return id * 31 + 17; // Example implementation, can be tuned later
    }
}
