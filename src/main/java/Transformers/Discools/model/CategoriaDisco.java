package Transformers.Discools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Access(AccessType.FIELD)
public class CategoriaDisco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nomeCategoriaDisco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "categoria_disco",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "disco_id"))
    private List<DiscosCD> discosCd = new ArrayList<>();

    public CategoriaDisco() {}

    public CategoriaDisco(int id, String nomeCategoriaDisco, List<DiscosCD> discosCd) {
        this.id = id;
        this.nomeCategoriaDisco = nomeCategoriaDisco;
        this.discosCd = discosCd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @JsonProperty("nome")
    public String getNomeCategoriaDisco() {
        return nomeCategoriaDisco;
    }

    public void setNomeCategoriaDisco(String nomeCategoriaDisco) {
        this.nomeCategoriaDisco = nomeCategoriaDisco;
    }

    public List<DiscosCD> getDiscosCd() {
        return discosCd;
    }

    public void setDiscosCd(List<DiscosCD> discosCd) {
        this.discosCd = discosCd;
    }
}