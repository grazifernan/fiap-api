package br.com.confiance.concessionaria.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "combustivel")
public class Combustivel {

    @Id
    @SequenceGenerator(name="combustivel", sequenceName="combustivel_cod_combustivel_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="combustivel")
    @Column(name="cod_combustivel")
    private Integer codCombustivel;

    @Column(name="nome")
    private String combustivel;

    public Combustivel(){}

    public Combustivel(Integer codCombustivel, String combustivel) {
        this.codCombustivel = codCombustivel;
        this.combustivel = combustivel;
    }

    public Integer getCodCombustivel() {
        return codCombustivel;
    }

    public void setCodCombustivel(Integer codCombustivel) {
        this.codCombustivel = codCombustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
}
