package persistence.sql.ddl;

import jakarta.persistence.Id;

public class ManyIdsEntity {
    @Id
    private Long id;

    @Id
    private Long id2;
}
