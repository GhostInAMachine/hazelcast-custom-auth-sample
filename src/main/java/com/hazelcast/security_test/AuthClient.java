package com.hazelcast.security_test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class AuthClient {
    public static void main(String[] args) {
        final ClientConfig config = new ClientConfig();
        config.setLicenseKey(System.getProperty("license.key"));
        final MyUserCredentials userCredentials = new MyUserCredentials("viktor", "pa$$", "hazelcast");
        config.getSerializationConfig()
                .addDataSerializableFactory(userCredentials.getFactoryId(), new UserCredentialsIDSFactory());


        config.setCredentials(userCredentials);


        final HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
    }
}
