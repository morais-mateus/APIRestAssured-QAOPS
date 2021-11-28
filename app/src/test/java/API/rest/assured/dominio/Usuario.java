package API.rest.assured.dominio;

public class Usuario {
        private String name;
        private String job;
        private String email;

        public Usuario(){};

        public Usuario(String nome, String job,String email){
            this.name= nome;
            this.job = job;
            this.email = email;
        }
        public String getName(){
            return name;
        }
        public String getJob(){
            return job;
        }
        public String getEmail(){return email;}

        public void setEmail(String email){ this.email =  email;}




}
