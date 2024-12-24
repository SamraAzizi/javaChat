public class Server implements Runnable{

    private ArrayList<ConnectionHandler> connections;




    @Override
    public void run(){
        try{

        
        ServerSocket server = new ServerSocket(9999);
        Socket cline = server.accept();
        ConnectionHandler handler = new ConnectionHandler(client);

        connections.add(handler);
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
    }
}

