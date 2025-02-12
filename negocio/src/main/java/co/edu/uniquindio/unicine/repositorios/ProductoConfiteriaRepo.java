package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.ProductoConfiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoConfiteriaRepo extends JpaRepository<ProductoConfiteria, Integer> {
}
