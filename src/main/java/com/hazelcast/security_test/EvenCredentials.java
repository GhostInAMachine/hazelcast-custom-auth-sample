package com.hazelcast.security_test;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import com.hazelcast.security.Credentials;

import java.io.IOException;

public class EvenCredentials implements IdentifiedDataSerializable, Credentials {

    public static final int CREDENTIAL_FACTORY_ID = 125;
    public static final int CREDENTIAL_CLASS_ID = 1;

    private String principal;
    private int factor;
    private int divisor;
    private String endpoint;

    public String getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getPrincipal() {
        return this.principal;
    }

    public int getFactoryId() {
        return CREDENTIAL_FACTORY_ID;
    }

    public int getId() {
        return CREDENTIAL_CLASS_ID;
    }

    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(principal);
        out.writeInt(factor);
        out.writeInt(divisor);
    }

    public void readData(ObjectDataInput objectDataInput) throws IOException {
        this.principal = objectDataInput.readUTF();
        this.factor = objectDataInput.readInt();
        this.divisor = objectDataInput.readInt();
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
}
