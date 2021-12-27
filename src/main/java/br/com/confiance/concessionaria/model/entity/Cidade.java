package br.com.confiance.concessionaria.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @SequenceGenerator(name="cidade", sequenceName="cidade_cod_cidade_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cidade")
    @Column(name="cod_cidade")
    private Integer codCidade;

    @JoinColumn(name="cod_estado")
    @ManyToOne
    private Estado codEstado;

    @Column(name="nome")
    private String cidade;

    public Cidade(){};

    public Cidade(Integer codCidade, Estado codEstado, String cidade) {
        this.codCidade = codCidade;
        this.codEstado = codEstado;
        this.cidade = cidade;
    }

    public Integer getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Integer codCidade) {
        this.codCidade = codCidade;
    }

    public Estado getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Estado codEstado) {
        this.codEstado = codEstado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
