package teste

class PlantaSucessao {

    String descricao
    
    //Planta planta
    //static belongsTo = [planta:Planta]
    
    static mapping = {
        //table "plantas_dev.tb_planta_sucessao"
        table "tb_planta_sucessao"
        descricao column: "descricao"
        version false
        id generator: 'sequence'
        //planta column: "fk_planta"
    }
}
