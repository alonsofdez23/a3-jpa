package req3;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "almacen")
public class Almacen {
    private List<Articulo> articulos;

    public Almacen() {
        articulos = new ArrayList<Articulo>();
    }

    @XmlElementWrapper(name = "articulos")
    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
