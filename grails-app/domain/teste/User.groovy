package teste

class User {

    String login
    String password
    String nomeUsuario
    
    static constraints = {
        table "tb_usuario"
        login column: "login"
        password column: "password"
        nomeUsuario column: "nome_usuario"
    }
}
