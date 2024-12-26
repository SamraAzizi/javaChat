# Chat Application

This project is a simple multi-client chat application implemented in Java using sockets. It consists of two main components:

- **Server**: Manages connections and broadcasts messages to all connected clients.
- **Client**: Connects to the server and allows users to send and receive messages.

## Features
- Real-time communication between multiple clients.
- Support for nickname changes.
- Graceful handling of client disconnection.
- Simple command system:
  - `/nick [new nickname]`: Change the nickname.
  - `/quit`: Disconnect from the chat.

## Files
- **`Server.java`**: The server-side implementation.
- **`Client.java`**: The client-side implementation.

## Prerequisites
- Java Development Kit (JDK) installed.
- A code editor like Visual Studio Code (VS Code).

## How to Run

### Server
1. Open a terminal and navigate to the directory containing `Server.java`.
2. Compile the server code:
   ```bash
   javac Server.java
   ```
3. Start the server:
   ```bash
   java Server
   ```

### Client
1. Open another terminal and navigate to the directory containing `Client.java`.
2. Compile the client code:
   ```bash
   javac Client.java
   ```
3. Start a client instance:
   ```bash
   java Client
   ```
4. Repeat step 3 in additional terminals to start multiple clients.

## Usage
- Upon connecting, each client is prompted to enter a nickname.
- Messages typed in the client terminal are broadcast to all connected clients.
- Commands:
  - `/nick [new nickname]`: Change your nickname.
  - `/quit`: Leave the chat.

## Known Issues
1. The `connections` list in `Server` is not thread-safe and may lead to concurrency issues.
2. Exceptions are not consistently logged or displayed.

## Enhancements
- Use a thread-safe collection like `CopyOnWriteArrayList` for `connections` in `Server`.
- Improve error handling and logging for better debugging.
- Add encryption for secure communication.
- Implement a graphical user interface (GUI) for the client.

## License
This project is free to use and modify. No license restrictions.

---

Happy chatting!