package teste

class DispersaoPlanta {

    String descricao
    
    //static belongsTo = [planta:Planta]
    
    static mapping = {
        //table "plantas_dev.tb_planta_dispersao"
        table "tb_planta_dispersao"
        descricao column: "descricao"
        version false
        id generator: 'sequence'
    }
}
