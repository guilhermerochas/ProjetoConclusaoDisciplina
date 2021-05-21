package resources;

import utils.OSUtils;

public class PdfUploadResource {
    private String message;
    private String url;

    public String getMessage() {
        return message;
    }

    public PdfUploadResource setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PdfUploadResource setUrl(String url) {
        this.url = url;
        return this;
    }
}
