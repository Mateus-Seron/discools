package Transformers.Discools.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private List<ItemDoPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(int id, List<ItemDoPedido> itens) {
        this.id = id;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }

    @Transient
    public float getTotal() {
        float total = 0;
        for (ItemDoPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemDoPedido item) {
        itens.remove(item);
    }
}
