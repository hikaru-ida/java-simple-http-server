package base.data;

public enum Status {
    OK(200, "200 OK"),
    BAD_REQUEST(400, "400 BadRequest"),
    NOT_FOUND(404, "404 NotFound");

    private final int statusCode;

    private final String statusText;

    Status(int statusCode, String statusText) {
        this.statusCode = statusCode;
        this.statusText = statusText;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusText() {
        return this.statusText;
    }
}
