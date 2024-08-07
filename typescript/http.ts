import http from "http";
import { AddressInfo } from "net";

/*
Original code source:
https://www.udemy.com/course/fundamentals-of-networking-for-effective-backend-design

:: (IPv6) -> 0.0.0.0 (IPv4)
Unspecified address
*/

const displayListeningMessage = (addressInfo: AddressInfo): void => {
    if (addressInfo.family === "IPv6") {
        console.log(
            `Listening on http://[${addressInfo.address}]:${addressInfo.port} (${addressInfo.family})`
        );
    } else {
        console.log(
            `Listening on http://${addressInfo.address}:${addressInfo.port} (${addressInfo.family})`
        );
    }
};

// -----

const httpServerIPv4 = http.createServer();
httpServerIPv4.on("request", (req, res) => res.end("Hey there!"));
httpServerIPv4.on("listening", () => {
    const addressInfo = httpServerIPv4.address() as AddressInfo;
    displayListeningMessage(addressInfo);
});
httpServerIPv4.on("error", (err) => {
    console.log(`Error ${err}`);
});
httpServerIPv4.listen(0, "127.0.0.1");

// -----

const httpServerIPv6 = http.createServer();
httpServerIPv6.on("request", (req, res) => res.end("Hey there!"));
httpServerIPv6.on("listening", () => {
    const addressInfo = httpServerIPv6.address() as AddressInfo;
    displayListeningMessage(addressInfo);
});
httpServerIPv6.on("error", (err) => {
    console.log(`Error ${err}`);
});
httpServerIPv6.listen(0, "::1");
