package com.hazelcast.security_test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class AuthClient {
    public static void main(String[] args) {
        final ClientConfig config = new ClientConfig();
        config.setLicenseKey(System.getProperty("license.key"));
        config.getSerializationConfig()
                .addDataSerializableFactory(EvenCredentials.CREDENTIAL_FACTORY_ID, new AuthFactory());

        final EvenCredentials credentials = new EvenCredentials();

        credentials.setPrincipal("me");
        credentials.setFactor(10);
        credentials.setDivisor(2);

        config.setCredentials(credentials);


        final HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
    }
}
