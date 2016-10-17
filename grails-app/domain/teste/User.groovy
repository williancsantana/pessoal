package teste

class User {

    String login
    String password
    String nomeUsuario
    
    static mapping = {
        //table "plantas_dev.tb_usuario"
        table "tb_usuario"
        login column: "login"
        password column: "password"
        nomeUsuario column: "nome_usuario"
        id generator: 'sequence'
        version false
    }
}
