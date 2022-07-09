package tri.dev.restful_cam.model;
import java.util.List;

public class config {
    private List<listServer> list_servers;

    public List<listServer> getList_servers() {
        return this.list_servers;
    }

    public void setList_servers(List<listServer> list_servers) {
        this.list_servers = list_servers;
    }

    public static class listServer {
        private String name;
        private String server;
        private String port;
        private String version;
        private String Request_ID;
        private String API_Key;
    
        public String getName() {
            return this.name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getServer() {
            return this.server;
        }
    
        public void setServer(String server) {
            this.server = server;
        }
    
        public String getPort() {
            return this.port;
        }
    
        public void setPort(String port) {
            this.port = port;
        }
    
        public String getVersion() {
            return this.version;
        }
    
        public void setVersion(String version) {
            this.version = version;
        }
    
        public String getRequest_ID() {
            return this.Request_ID;
        }
    
        public void setRequest_ID(String Request_ID) {
            this.Request_ID = Request_ID;
        }
    
        public String getAPI_Key() {
            return this.API_Key;
        }
    
        public void setAPI_Key(String API_Key) {
            this.API_Key = API_Key;
        }
    
    }

}

