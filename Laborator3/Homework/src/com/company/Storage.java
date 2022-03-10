package com.company;

import java.math.BigInteger;

public interface Storage {
    int getStorageCapacity();

    default BigInteger getStorageCapacityInMB(int storageCapacity) {
        return BigInteger.valueOf(storageCapacity).multiply(new BigInteger("1000"));
    }

    default BigInteger getStorageCapacityInKB(int storageCapacity) {
        return BigInteger.valueOf(storageCapacity).multiply(new BigInteger("1000000"));
    }

    default BigInteger getStorageCapacityInBytes(int storageCapacity) {
        return BigInteger.valueOf(storageCapacity).multiply(new BigInteger("1000000000"));

    }
}