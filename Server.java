public class Server implements Runnable{

    private ArrayList<ConnectionHandler> connections;

    private ServerSocket server;
    private boolean done;

    public Server(){
        connections = new ArrayList<>();
        done = false;
    }




    @Override
    public void run(){
        try{

        
            server = new ServerSocket(9999);
            while(!done){

            
                Socket cline = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);

                connections.add(handler);
            }
        }catch (IOException e){
            
            }


    }

    public void broadcast(String message){
        for(ConnectionHandler ch :connections){
            if(ch != null){
                ch.message(message);
            }

        }
    }

    public void shutdown(){
        try{

        
            done = true;
            if(!server.isClosed()){
                server.close();
        }
        for(ConnectionHandler ch: connections){
            ch.shutdown
        }

        }catch(IOException e){

        }

    }

    class ConnectionHandler implements Runnable{
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;


        public ConnectionHandler(Socket cline){
            this.client = client;

        }

        @Override
        public void run(){
            try{
                out = new PrintWriter(client.getOutPutStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Please enter a nickname:");
                nickname = in.readLine();
                
                
                System.out.println(nickname + " connected!");
                broadcast(nickname + " joined the chat!")
                String message;
                while ((message = in.readLine()) != null){
                    if(message.startWith("/nick ")){
                        String[] messageSplit = message.split(" ", 2);
                        if(messageSplit.length == 2){
                            broadcast(nickname + " renamed themselver to "+messageSplit[1])
                            System.out.println(nickname + " renamed themselver to "+messageSplit[1])
                            nickname = messageSplit[1]
                            out.println("Successfully changed nickename to "+ nickname)
                        }else{
                            out.println("No nickname provided")
                        }
                        
                    }else if(message.startWith("/quit")){

                    }else{
                        broadcast(nickname+ ": "+ message)
                    }
                }

            }catch(IOException){

            }

        }

        public void sendMessage(String message){
            out.println(message);
        }
        public void shutdown(){
            try{

            
            in.close();
            out.close()
            if(!client.isClosed()){
                client.close()
            }
        }catch(IOException e){

        }
        }
    }
}

