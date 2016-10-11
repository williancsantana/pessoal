package teste

class CategoriaAmeaca {
    String descricao
    
    static mapping = {
        table "plantas_dev.tb_categoria_ameaca"
        descricao column: "descricao"
        version false
    }
}
