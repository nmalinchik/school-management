package com.mallinapps.designdomain.controller.api.common;

import io.swagger.annotations.ApiModel;

@ApiModel
public final class InnerError {
    private String message;
    private String clientMessage;
    private String detailsLink;
    private String target;

    private InnerError() {
        //Builder is responsible for object creation
    }

    public String getMessage() {
        return message;
    }

    public String getClientMessage() {
        return clientMessage;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public String getTarget() {
        return target;
    }

    public static class InnerErrorBuilder {
        private String message;
        private String clientMessage;
        private String detailsLink;
        private String target;

        public InnerErrorBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public InnerErrorBuilder setClientMessage(String clientMessage) {
            this.clientMessage = clientMessage;
            return this;
        }

        public InnerErrorBuilder setDetailsLink(String detailsLink) {
            this.detailsLink = detailsLink;
            return this;
        }

        public InnerErrorBuilder setTarget(String target) {
            this.target = target;
            return this;
        }

        public InnerError build() {
            InnerError innerError = new InnerError();
            innerError.clientMessage = clientMessage;
            innerError.detailsLink = detailsLink;
            innerError.message = message;
            innerError.target = target;

            return innerError;
        }
    }
}

