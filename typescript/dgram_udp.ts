import dgram from "dgram";

/*
Use the following command to try it yourself.
nc -u 127.0.0.1 5500
*/

const socket = dgram.createSocket("udp4");

socket.bind(5500, "127.0.0.1");
socket.on("message", (msg, info) => {
    console.log(
        `* My server got a datagram from ${info.address}:${info.port}\n: ${msg}`
    );
});
