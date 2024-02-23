package persistence.sql.dialect;

import jakarta.persistence.GenerationType;
import persistence.sql.constant.ColumnType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class H2Dialect implements Dialect {

    private final Map<ColumnType, String> typeNameMap = new HashMap<>();
    private final Map<GenerationType, String> generationStrategyMap = new HashMap<>();

    public H2Dialect() {
        initTypeNameMap();
        initGenerationStrategyMap();
    }

    private void initTypeNameMap() {
        typeNameMap.put(ColumnType.VARCHAR, "VARCHAR(255)");
        typeNameMap.put(ColumnType.INTEGER, "INTEGER");
        typeNameMap.put(ColumnType.BIGINT, "BIGINT");
        typeNameMap.put(ColumnType.BOOLEAN, "BOOLEAN");
    }

    private void initGenerationStrategyMap() {
        generationStrategyMap.put(GenerationType.AUTO, "generated by default as identity");
        generationStrategyMap.put(GenerationType.IDENTITY, "generated by default as identity");
        generationStrategyMap.put(GenerationType.UUID, "");
        generationStrategyMap.put(GenerationType.TABLE, "");
        generationStrategyMap.put(GenerationType.SEQUENCE, "");
    }

    @Override
    public String getTypeName(ColumnType columnType) {
        if (!typeNameMap.containsKey(columnType)) {
            throw new UnsupportedColumnTypeException();
        }
        return typeNameMap.get(columnType);
    }

    @Override
    public String getGenerationStrategy(GenerationType generationType) {

        if (Objects.isNull(generationType)) {
            return "";
        }

        if (!generationStrategyMap.containsKey(generationType)) {
            throw new UnsupportedColumnTypeException();
        }
        return generationStrategyMap.get(generationType);
    }

}
