var HazelcastClient = require("./HazelcastClient").default;
var ClientConfig = require("./Config").ClientConfig;
var Address = require("./Address");


var clientConfig = new ClientConfig();

function CustomCredentials(principal, factor, divisor) {
    this.principal = principal;
    this.factor = factor;
    this.divisor = divisor;
}

CustomCredentials.prototype.writeData = function (output) {
    output.writeUTF(this.principal);
    output.writeInt(this.factor);
    output.writeInt(this.divisor);
};

CustomCredentials.prototype.readData = function (input) {
    this.principal = input.readUTF();
    this.factor = input.readInt();
    this.divisor = input.readInt();
};

CustomCredentials.prototype.getFactoryId = function () {
    return 125;
};

CustomCredentials.prototype.getClassId = function () {
    return 1;
};

clientConfig.customCredentials = new CustomCredentials("me", 10, 5);


HazelcastClient.newHazelcastClient(clientConfig).then(function (client) {
    console.log("Login successful!")
}).catch(function (e) {
    console.log(e.stack);
});


