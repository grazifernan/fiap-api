package br.com.confiance.concessionaria.model.entity;

import br.com.confiance.concessionaria.model.dto.CreateVeiculo;
import br.com.confiance.concessionaria.model.dto.VeiculoDTO;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @SequenceGenerator(name="veiculo", sequenceName="veiculo_cod_veiculo_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
    @Column(name="cod_veiculo")
        private int id;

    @ManyToOne
    @JoinColumn(name="cod_modelo")
    private Modelo codModelo;

    @Column(name="km")
    private Long km;

    @ManyToOne
    @JoinColumn(name="cod_cor")
    private Cor codCor;

    @Column(name="placa")
    private String placa;

    @ManyToOne
    @JoinColumn(name="cod_empresa")
    private Filial codFilial;

    @Column(name="complemento")
    private String descricao;

    @Column(name="renavam")
    private long renavam;

    @Column(name="valor")
    private float valor;

    public Veiculo(){}

    //    public Veiculo(CreateVeiculo veiculo) {
    public Veiculo(VeiculoDTO veiculo) {
        //this.id = veiculo.getId();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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
}
