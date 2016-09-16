'use strict';

const HazelcastClient = require("hazelcast-client").Client;
const Config = require("hazelcast-client").Config;


let clientConfig = new Config.ClientConfig();

class CustomCredentials {
  constructor(principal, factor, divisor) {
    this.principal = principal;
    this.factor = factor;
    this.divisor = divisor;
  }

  writeData(output) {
    output.writeUTF(this.principal);
    output.writeInt(this.factor);
    output.writeInt(this.divisor);
  }

  readData(input) {
    this.principal = input.readUTF();
    this.factor = input.readInt();
    this.divisor = input.readInt();
  }

  getFactoryId() {
    return 125;
  }

  getClassId() {
    return 1;
  }
}

clientConfig.customCredentials = new CustomCredentials("me", 10, 5);


HazelcastClient
  .newHazelcastClient(clientConfig)
  .then(client => console.log("Login successful!"))
  .catch(e => console.log(e.stack));


