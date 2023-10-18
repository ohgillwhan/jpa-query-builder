package persistence.annotations;

public enum GenerationType {
    IDENTITY("generated by default as identity");

    private final String createQuery;

    GenerationType(String createQuery) {
        this.createQuery = createQuery;
    }

    public String getCreateQuery() {
        return createQuery;
    }
}


