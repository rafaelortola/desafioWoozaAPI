package Enums;

public enum EndpointsEnum {

    BUSCARPESSOA(1,"https://swapi.dev/api/people/");

    private Integer codigo;
    private String descricao;

    EndpointsEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
