package com.hazelcast.security_test;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import com.hazelcast.security.Credentials;

import java.io.IOException;

/**
 * Created by vikgamov on 9/20/16.
 */
public class MyUserCredentials implements IdentifiedDataSerializable, Credentials {
    private String username;
    private String password;
    private String applicationId;

    public MyUserCredentials(String username, String password, String applicationId) {
        this.username = username;
        this.password = password;
        this.applicationId = applicationId;
    }

    public MyUserCredentials() {

    }


    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(username);
        out.writeUTF(password);
        out.writeUTF(applicationId);
    }


    public void readData(ObjectDataInput in) throws IOException {
        this.username = in.readUTF();
        this.password = in.readUTF();
        this.applicationId = in.readUTF();
    }


    public int getFactoryId() {
        return 33;
    }

    public int getId() {
        return 3301;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getEndpoint() {
        return null;
    }

    public void setEndpoint(String s) {

    }

    public String getPrincipal() {
        return null;
    }
}
