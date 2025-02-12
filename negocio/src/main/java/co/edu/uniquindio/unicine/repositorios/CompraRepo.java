package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dto.InformacionComprasCliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select ent from Compra c join c.entradas ent where c.codigo = :idCompra")
     List<Entrada> obtenerEntradasPorID(Integer idCompra);

    @Query("select sum(c.precioTotal) from Compra c where c.cliente.cedula = :cedulaCliente")
    Float calcularPrecioCompras(String cedulaCliente);

    @Query("select c.cliente, c.precioTotal from Compra c where c.precioTotal " +
            " = (select max(c1.precioTotal) from Compra c1)")
    List<Object[]> calcularCompraMasCostosa();
    @Query("select c.precioTotal, c.fechaCompra, c.funcion, " +
            "(select sum(conf.precio) from CompraConfiteria conf where conf.compra.codigo = c.codigo), " +
            "(select sum(e.precio) from Entrada e where e.compra.codigo = c.codigo)" +
            "from Compra c where c.cliente.cedula = :cedulaCliente")
    List<Object[]> mostrarInformacionCompras(String cedulaCliente);

}
