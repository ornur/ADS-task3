package org.example;

class MyTestingClass {
    private final int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    // Custom hashCode implementation
    @Override
    public int hashCode() {
        return id * 31 + 17; // Example implementation, can be tuned later
    }
    @Override
    public String toString(){
        return String.valueOf(id);
    }
}
