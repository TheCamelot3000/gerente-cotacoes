package br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database;

public class ExceptionDetails {
    private String title;
    private int status;
    private String details;
    private long timestamp;
    private String developMessage;

    private ExceptionDetails() {
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDevelopMessage() {
        return developMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String developMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder withDetails(String details) {
            this.details = details;
            return this;
        }

        public Builder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withDevelopMessage(String developMessage) {
            this.developMessage = developMessage;
            return this;
        }

        public ExceptionDetails build() {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.developMessage = this.developMessage;
            exceptionDetails.status = this.status;
            exceptionDetails.timestamp = this.timestamp;
            exceptionDetails.title = this.title;
            exceptionDetails.details = this.details;
            return exceptionDetails;
        }
    }
}
