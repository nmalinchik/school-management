package com.mallinapps.commondto.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mallinapps.commondto.dto.exception.ArgumentMismatchException;
import lombok.Builder;

public class CommonPageResource {

    private final int page;
    private final int size;

    @JsonProperty("total_elements")
    private final long totalElements;

    @Builder
    public CommonPageResource(final int page, final int size, final long totalElements) {
        validate(page, size, totalElements);
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
    }

    private static void validate(final int page, final int size, final long totalElements) {
        final var totalPages = (long) Math.ceil((double) totalElements / size);
        if (!(totalPages == 0 && page == 0) && page > totalPages - 1) {
            throw new ArgumentMismatchException(String.format("The last page number for %d elements is %d. Page %d is therefore invalid.", totalElements, totalPages - 1, page));
        }
    }

    @JsonProperty("total_pages")
    public long getTotalPages() {
        return (long) Math.ceil((double) totalElements / size);
    }

    @JsonProperty("isLastPage")
    public Boolean isLastPage() {
        return totalElements == 0 || page == getTotalPages() - 1;
    }

}
