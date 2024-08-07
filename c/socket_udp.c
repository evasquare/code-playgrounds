#include <arpa/inet.h>
#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>

/*
Original code source:
https://www.udemy.com/course/fundamentals-of-networking-for-effective-backend-design

Use the following command to try it yourself.
nc -u 127.0.0.1 5501
*/

int main(int argc, char** argv) {
    int port = 5501;
    int sockfd;  // socket file descriptor
    struct sockaddr_in myaddr, remoteAddr;
    char buffer[1024];
    socklen_t addr_size;

    /* A socket is created with the socket function.
       AF_INET    -> Specifies the IPv4 protocol
       SOCK_DGRAM -> Specifies UDP
       the last parameter -> Protocol */
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    /* The server's address structure is cleared with memset,
       and then the family (IPv4), port number, and IP address are set.

       - htons function:
         used to ensure that the port number is in network byte order
       - inet_addr:
         used to convert the IP address to binary form. */
    memset(&myaddr, '\0', sizeof(myaddr));
    myaddr.sin_family = AF_INET;
    myaddr.sin_port = htons(port);
    myaddr.sin_addr.s_addr = inet_addr("127.0.0.1");

    bind(sockfd, (struct sockaddr*)&myaddr, sizeof(myaddr));
    addr_size = sizeof(remoteAddr);
    /* Typecast
       The (struct sockaddr*) before &myaddr and
       &remoteAddr is a type cast. It tells the compiler
       to treat the &myaddr and &remoteAddr pointers
       as pointers to a struct sockaddr.

       This is done because while struct sockaddr_in is
       used for IP address handling, the socket functions
       expect a pointer to struct sockaddr.

       So we typecast the pointer to the struct sockaddr_in structure to
       struct sockaddr*. This is safe because struct sockaddr_in is
       designed to have the same memory layout as
       the first part of struct sockaddr.

       # Fourth Argument
       The fourth argument to the recvfrom() function in C
       is a set of flags that can be used to influence
       the behavior of the function. In your code, it's set to 0,
       which means no flags are being used. */
    recvfrom(sockfd, buffer, 1024, 0, (struct sockaddr*)&remoteAddr, &addr_size);
    printf("got data from %s\n", buffer);

    return 0;
}