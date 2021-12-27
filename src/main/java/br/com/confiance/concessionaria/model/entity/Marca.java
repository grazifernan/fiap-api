package br.com.confiance.concessionaria.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "marca_veiculo")
public class Marca {
    @Id
    @SequenceGenerator(name="marca", sequenceName="marca_veiculo_cod_marca_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="marca")
    @Column(name="cod_marca")
    private Integer codMarca;

    @Column(name="descricao")
    private String marca;

    public Marca(){}

    public Marca(Integer codMarca, String marca) {
        this.codMarca = codMarca;
        this.marca = marca;
    }

    public Integer getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
