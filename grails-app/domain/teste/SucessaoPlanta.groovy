package teste

class Sucessao_Planta {

    String descricao
    
    static belongsTo = [planta:Planta]
    
    static constraints = {
        table "tb_planta_sucessao"
        descricao column: "descricao"
        //planta column: "fk_planta"
    }
}
