package teste

class DispersaoPlanta {

    String descricao
    
    static belongsTo = [planta:Planta]
    
    static constraints = {
        table "tb_planta_dispersao"
        descricao column: "descricao"
    }
}
