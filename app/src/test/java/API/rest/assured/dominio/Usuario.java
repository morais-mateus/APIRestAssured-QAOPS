package API.rest.assured.dominio;

public class Usuario {
        private String name;
        private String job;

        public Usuario(){};

        public Usuario(String nome, String job){
            this.name= nome;
            this.job = job;
        }
        public String getName(){
            return name;
        }
        public String getJob(){
            return job;
        }


}
