package org.dive.simples.commonscsv;

public enum Headers {
    ACCOUNT_UUID("ACCOUNT_UUID", false),
    USERNAME("LOGIN_NAME", false),
    LOGIN_METHOD("LOGIN_METHOD", false),
    LOCALE("LOCALE", false),
    TIMEZONE("TIME_ZONE", false),
    PERSON_ID_EXTERNAL("PERSON_ID", true),
    ACCOUNT_STATUS("ACCOUNT_STATUS", true),
    ACCOUNT_TYPE("ACCOUNT_TYPE", true);
    private final String header;

    private final boolean readOnly;

    Headers(String header, boolean readOnly) {
        this.header = header;
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

}
