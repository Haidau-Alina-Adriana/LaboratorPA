package com.company;

public interface Storage {
    int getStorageCapacity();

    default double getStorageCapacityInMB() {
        return getStorageCapacity() * 1024;
    }

    default double getStorageCapacityInKB() {
        return getStorageCapacity() * Math.pow(1024, 2);
    }

    default double getStorageCapacityInBytes(int storageCapacity) {
        return getStorageCapacity() * Math.pow(1024, 3);
    }
}