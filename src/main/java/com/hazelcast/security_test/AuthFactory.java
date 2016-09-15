package com.hazelcast.security_test;

import com.hazelcast.nio.serialization.DataSerializableFactory;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

public class AuthFactory implements DataSerializableFactory {
    public IdentifiedDataSerializable create(int i) {

        if (i == EvenCredentials.CREDENTIAL_CLASS_ID) {
            return new EvenCredentials();
        }

        return null;
    }
}
