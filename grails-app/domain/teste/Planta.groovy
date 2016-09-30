package teste

class Planta {

    String nome
    String nomeCientifico
    Float custoMuda
    Boolean nativoCerrado
    Boolean ameacadoExtincao
    
    DispersaoPlanta dispersaoPlanta
    //SucessaoPlanta sucessaoPlanta
    
//    static hasOne = [dispersaoPlanta: DispersaoPlanta]
//    static hasOne = [sucessaoPlanta: SucessaoPlanta]
    static hasMany = [cotacaoPlanta: CotacaoPlanta]
    
    
    
    static constraints = {
        table "tb_planta"
        nome column: "nome"
        nomeCientifico column: "nome_cientifico"
        ameacadoExtincao column: "ameacado_extincao"
        nativoCerrado column: "nativo_cerrado"
        dispersaoPlanta column: "fk_dispersao_planta"
        sucessaoPlanta column: "fk_sucessao_planta"
    }
}
