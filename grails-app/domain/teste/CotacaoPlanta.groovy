package teste

class CotacaoPlanta {
    
    String descricao
    Integer tempoAbasteAnos
    Double receitaEstimada
    
    Planta planta
    //static belongsTo = [planta:Planta]
    
    static mapping = {
        table "plantas_dev.tb_planta_cotacao"
        descricao column: "descricao"
        tempoAbasteAnos column: "tempo_abaste_anos"
        receitaEstimada column: "receita_estimada"
        planta column: "fk_planta"
        version false
    }
}
