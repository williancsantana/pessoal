package teste

class PlantaSucessao {

    String descricao
    
    Planta planta
    //static belongsTo = [planta:Planta]
    
    static mapping = {
        table "tb_planta_sucessao"
        descricao column: "descricao"
        version false
        //planta column: "fk_planta"
    }
}
