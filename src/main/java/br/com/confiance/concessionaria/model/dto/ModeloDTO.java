package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Combustivel;
import br.com.confiance.concessionaria.model.entity.Marca;
import br.com.confiance.concessionaria.model.entity.Modelo;

public class ModeloDTO {

    private int codModelo;
    private int codMarca;
    private int codCombustivel;
    private Long ano;
    private String descricao;

    public ModeloDTO(){};

    public ModeloDTO(Modelo modelo){

        Marca marca;
        Combustivel combustivel;
        marca = modelo.getCodMarca();
        combustivel = modelo.getCodCombustivel();
        this.codModelo = modelo.getCodModelo();
        this.codMarca = marca.getCodMarca();
        this.descricao = modelo.getModelo();
        this.ano = modelo.getAno();
        this.codCombustivel = combustivel.getCodCombustivel();
    }

    public int getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(int codModelo) {
        this.codModelo = codModelo;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public int getCodCombustivel() {
        return codCombustivel;
    }

    public void setCodCombustivel(int codCombustivel) {
        this.codCombustivel = codCombustivel;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
