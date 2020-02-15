package Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private float total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
