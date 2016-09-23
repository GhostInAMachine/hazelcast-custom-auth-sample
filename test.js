'use strict';

const HazelcastClient = require('hazelcast-client').Client;
const Config = require('hazelcast-client').Config;


let clientConfig = new Config.ClientConfig();

class UserCredentials {
  constructor(user, password, applicationId) {
    this.user = user;
    this.password = password;
    this.applicationId = applicationId;
  }

  writeData(output) {
    output.writeUTF(this.user);
    output.writeUTF(this.password);
    output.writeUTF(this.applicationId);
  }

  readData(input) {
    this.user = input.readUTF();
    this.password = input.readUTF();
    this.applicationId = input.readUTF();
  }

  getFactoryId() {
    return 33;
  }

  getClassId() {
    return 3301;
  }
}

clientConfig.customCredentials = new UserCredentials("viktor", "pa$$", "hazelcast");


HazelcastClient
  .newHazelcastClient(clientConfig)
  .then(client => console.log("Login successful!"))
  .catch(e => console.log(e.stack));


