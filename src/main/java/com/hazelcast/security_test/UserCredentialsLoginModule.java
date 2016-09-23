package com.hazelcast.security_test;

import com.hazelcast.security.ClusterLoginModule;

import javax.security.auth.login.LoginException;

/**
 * Created by vikgamov on 9/20/16.
 */
public class UserCredentialsLoginModule extends ClusterLoginModule {
    protected boolean onLogin() throws LoginException {
        if (this.credentials instanceof MyUserCredentials) {
            MyUserCredentials uc = (MyUserCredentials) this.credentials;
            if ("hazelcast".equals(uc.getApplicationId())
                    && "viktor".equals(uc.getUsername())
                    && "pa$$".equals(uc.getPassword())) {
                return true;
            }
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
