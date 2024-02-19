package br.com.adatech.billboardsongs.modelo;

public abstract class Pessoa {

    private Long id;
    private String nome;
    private Boolean ativo;

    public Pessoa(String nome) {
        this.nome = nome;
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
