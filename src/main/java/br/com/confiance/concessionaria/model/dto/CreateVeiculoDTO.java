package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Cor;
import br.com.confiance.concessionaria.model.entity.Modelo;
import br.com.confiance.concessionaria.model.entity.Filial;

public class CreateVeiculoDTO {
    private int codModelo;
    private Long km;
    private int codCor;
    private String placa;
    private int codFilial;
    private String descricao;

    private long renavam;
    private float valor;

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(int codModelo) {
        this.codModelo = codModelo;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public int getCodCor() {
        return codCor;
    }

    public void setCodCor(int codCor) {
        this.codCor = codCor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
