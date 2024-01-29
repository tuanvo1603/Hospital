package project.hospital.constant;

public enum StatusCode {

    SUCCESS(0),

    UNKNOWN(1),
    INVALID(2),

    REQUEST(3);

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
