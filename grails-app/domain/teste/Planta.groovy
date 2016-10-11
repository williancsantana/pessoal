package teste

class Planta {

    String nome
    String nomeCientifico
    Double custoMuda
    Boolean nativoCerrado
    Boolean ameacadoExtincao
    
    DispersaoPlanta dispersaoPlanta
    PlantaSucessao plantaSucessao
    
//    static hasOne = [dispersaoPlanta: DispersaoPlanta]
//    static hasOne = [sucessaoPlanta: SucessaoPlanta]
    //static hasMany = [cotacaoPlanta: CotacaoPlanta]
    
    
    
    static mapping = {
        table "plantas_dev.tb_planta"
        nome column: "nome"
        nomeCientifico column: "nome_cientifico"
        ameacadoExtincao column: "ameacado_extincao"
        custoMuda column: "custo_muda"
        nativoCerrado column: "nativo_cerrado"
        dispersaoPlanta column: "fk_dispersao_planta"
        plantaSucessao column: "fk_sucessao_planta"
        version false
    }
}
