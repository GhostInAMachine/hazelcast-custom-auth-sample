package com.hazelcast.security_test;

import com.hazelcast.nio.serialization.DataSerializableFactory;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

/**
 * Created by vikgamov on 9/20/16.
 */
public class UserCredentialsIDSFactory implements DataSerializableFactory {
    public IdentifiedDataSerializable create(int i) {
        if (i == 3301) {
            return new MyUserCredentials();
        }
        return null;
    }
}
