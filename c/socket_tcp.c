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
nc 127.0.0.1 8801
*/

#define PORT 8801

int main() {
    int sockfd;  // socket file descriptor
    struct sockaddr_in server_addr;

    int new_socket;
    struct sockaddr_in new_addr;

    socklen_t addr_size;
    char buffer[1024];

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    printf("Server Socket Created Successfully.\n");
    memset(&server_addr, '\0', sizeof(server_addr));

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    /* The server_addr structure needs to have the same fields defined as in sockaddr.
       This is because the bind function, which binds the socket to an address,
       expects a pointer to a sockaddr structure as its second argument. */
    bind(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr));
    printf("[+]Bind to port number %d.\n", PORT);

    listen(sockfd, 5);
    printf("[+]Listening...\n");

    new_socket = accept(sockfd, (struct sockaddr*)&new_addr, &addr_size);

    /* strcpy is a C standard library function that copies
       a string from one location to another. */
    strcpy(buffer, "Hello\n");
    send(new_socket, buffer, strlen(buffer), 0);
    printf("[+]Closing the connection.\n");

    return 0;
}