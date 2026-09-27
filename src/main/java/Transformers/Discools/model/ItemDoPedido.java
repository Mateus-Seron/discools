package Transformers.Discools.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
public class ItemDoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disco_id")
    private DiscosCD disco;

    private int quantidade;

    public ItemDoPedido() {}

    public ItemDoPedido(int id, DiscosCD disco, int quantidade) {
        this.id = id;
        this.disco = disco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiscosCD getDisco() {
        return disco;
    }

    public void setDisco(DiscosCD disco) {
        this.disco = disco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Transient
    public float getSubtotal() {
        if (disco != null) {
            return disco.getPreco() * quantidade;
        }
        return 0;
    }
}
