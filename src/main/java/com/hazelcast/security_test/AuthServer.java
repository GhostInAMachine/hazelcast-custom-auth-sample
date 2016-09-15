package com.hazelcast.security_test;

import com.hazelcast.config.Config;
import com.hazelcast.config.LoginModuleConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class AuthServer {
    public static void main(String[] args) {
        final LoginModuleConfig loginModuleConfig = new LoginModuleConfig();
        loginModuleConfig.setClassName(CustomLoginModule.class.getName());
        loginModuleConfig.setUsage(LoginModuleConfig.LoginModuleUsage.REQUIRED);

        final Config config = new Config();
        config.getSerializationConfig()
                .addDataSerializableFactory(EvenCredentials.CREDENTIAL_FACTORY_ID, new AuthFactory());

        config.setLicenseKey(System.getProperty("license.key"));

        config.getSecurityConfig()
                .setEnabled(true).addClientLoginModuleConfig(loginModuleConfig);

        final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
    }
}
