package br.com.confiance.concessionaria.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @SequenceGenerator(name="estado", sequenceName="estado_cod_estado_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="estado")
    @Column(name="cod_estado")
    private Integer codEstado;

    @Column(name="nome")
    private String estado;

    @Column(name="sigla")
    private char sigla;

    public Estado(){};

    public Estado(Integer codEstado, String estado, char sigla) {
        this.codEstado = codEstado;
        this.estado = estado;
        this.sigla = sigla;
    }

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }
}
