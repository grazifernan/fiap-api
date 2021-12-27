package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Cor;
import br.com.confiance.concessionaria.model.entity.Veiculo;
import br.com.confiance.concessionaria.model.entity.Filial;
import br.com.confiance.concessionaria.model.entity.Modelo;

public class VeiculoDTO {

    private int id;
    private Modelo codModelo;
    private Long km;
    private Cor codCor;
    private String placa;
    private Filial codFilial;
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


    public VeiculoDTO(){}

    public VeiculoDTO(Veiculo veiculo){
        this.id = veiculo.getId();
        this.codModelo = veiculo.getCodModelo();
        this.km = veiculo.getKm();
        this.codCor = veiculo.getCodCor();
        this.placa = veiculo.getPlaca();
        this.codFilial = veiculo.getCodFilial();
        this.descricao = veiculo.getDescricao();
        this.renavam = veiculo.getRenavam();
        this.valor = veiculo.getValor();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Modelo getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(Modelo codModelo) {
        this.codModelo = codModelo;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public Cor getCodCor() {
        return codCor;
    }

    public void setCodCor(Cor codCor) {
        this.codCor = codCor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Filial getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(Filial codFilial) {
        this.codFilial = codFilial;
    }

   // public String getFilial() {
  //      return filial;
  //  }

  //  public void setFilial(String filial) {
 //       this.filial = filial;
  //  }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
