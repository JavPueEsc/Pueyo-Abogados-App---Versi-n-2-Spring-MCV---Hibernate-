package com.jpueyodev.integrationtest;

import javax.sql.DataSource;
import com.jpueyodev.HibernateConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HibernateConfig.class,
                      initializers = TestcontainersMySqlInitializer.class)
class DataSourceIT {

    @Autowired 
    DataSource dataSource;

    @AfterAll
    static void stop() { TestcontainersMySqlInitializer.MYSQL.stop(); }

    @Test
    void abreConexionYEjecutaSelect1() throws Exception {
        try (var cn = dataSource.getConnection()) {
            assertTrue(cn.isValid(2));
            try (var st = cn.createStatement(); var rs = st.executeQuery("SELECT 1")) {
                assertTrue(rs.next());
                assertEquals(1, rs.getInt(1));
            }
        }
    }
}


