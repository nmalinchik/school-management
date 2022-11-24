package com.mallinapps.designdomain.controller.api.common;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Base error response for all errors with status codes 400+ and 500.
 */
@ApiModel(value = "ErrorResponse", description = "Class representing the default error response")
public final class ErrorResponse {
    @ApiModelProperty(value = "the date-time notation", example = "2019-10-04T16:57:24.373014")
    private LocalDateTime timestamp;

    @ApiModelProperty(value = "the unique error code")
    private String code;

    @ApiModelProperty(value = "the path which is used by user")
    private String path;

    @ApiModelProperty(value = "HTTP Status code", example = "400")
    private int status;

    @ApiModelProperty(value = "the error type",
            allowableValues = "security, request, validation, constraint, internal",
            example = "validation")
    private String type;

    @ApiModelProperty(value = "the detailed description of the error", example = "The User name is not valid")
    private String message;

    @ApiModelProperty(value = "the list of inner errors")
    private List<InnerError> errors;

    private ErrorResponse() {
        //Builder is responsible for object creation
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public List<InnerError> getErrors() {
        return errors;
    }

    public static class ErrorResponseBuilder {
        private LocalDateTime timestamp;
        private String code;
        private int status;
        private String message;
        private String type;
        private String path;
        private List<InnerError> errors;

        public ErrorResponseBuilder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorResponseBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public ErrorResponseBuilder setStatus(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder setType(ErrorType type) {
            this.type = type.getType();
            return this;
        }

        public ErrorResponseBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public ErrorResponseBuilder setErrors(List<InnerError> errors) {
            this.errors = errors;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.timestamp = timestamp;
            errorResponse.code = code;
            errorResponse.path = path;
            errorResponse.errors = errors;
            errorResponse.message = message;
            errorResponse.status = status;
            errorResponse.type = type;

            return errorResponse;
        }
    }
}


