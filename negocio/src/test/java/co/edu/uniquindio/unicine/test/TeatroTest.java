package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.TeatroRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {

    @Autowired
    private TeatroRepo teatroRepo;

}
