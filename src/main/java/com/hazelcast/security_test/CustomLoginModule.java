package com.hazelcast.security_test;

import com.hazelcast.security.ClusterLoginModule;

import javax.security.auth.login.LoginException;

public class CustomLoginModule extends ClusterLoginModule {
    protected boolean onLogin() throws LoginException {

        if (credentials instanceof EvenCredentials) {
            final EvenCredentials evenCredentials = (EvenCredentials) this.credentials;
            final int factor = evenCredentials.getFactor();
            final int divisor = evenCredentials.getDivisor();

            if (factor % divisor != 0) {
                throw new LoginException(String.format("%d does not divide by %d without remainder", factor, divisor));
            }

            return true;
        }

        return false;
    }

    protected boolean onCommit() throws LoginException {
        return true;
    }

    protected boolean onAbort() throws LoginException {
        return true;
    }

    protected boolean onLogout() throws LoginException {
        return true;
    }
}
