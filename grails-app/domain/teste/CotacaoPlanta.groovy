package teste

class CotacaoPlanta {
    
    String descricao
    Integer tempoAbasteAnos
    Float receita
    
    static belongsTo = [planta:Planta]
    
    static constraints = {
        table "tb_planta_cotacao"
        descricao column: "descricao"
        tempoAbasteAnos column: "tempo_abaste_anos"
        receita column: "receita"
        planta column: "fk_planta"
    }
}
