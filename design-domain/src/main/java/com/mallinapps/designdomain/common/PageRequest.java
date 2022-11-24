package com.mallinapps.designdomain.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Schema(name = "Page Request")
@EqualsAndHashCode
public class PageRequest {

    private final PageConfigurer configurer;

    @Schema(description = "Page number", example = "3")
    @Getter
    private int page = PageConfigurer.DEFAULT_FIRST_PAGE.getNumber();

    @Schema(description = "Page size", example = "20")
    @Getter
    private int size = PageConfigurer.DEFAULT_SIZE;

    public PageRequest(final Integer page, final Integer size) {
        this(page, size, null);
    }

    public PageRequest(final Integer page, final Integer size, final PageConfigurer configurer) {
        this.configurer = configurer == null ? PageConfigurer.createDefault() : configurer;
        setPage(page);
        setSize(size);
    }

    private void setPage(final Integer page) {
        this.page = page == null || page < this.configurer.getFirstPageNumber() ? this.configurer.getFirstPageNumber() : page;
    }

    private void setSize(final Integer size) {
        this.size = size == null || size < 0 ? this.configurer.getDefaultSize() : size;
    }

    private boolean isFirstPage() {
        return this.page == configurer.getFirstPageNumber();
    }

    public final long getNumberOfSkippedElements() {
        return !isFirstPage() && !isFullPageRequest() ? (long) this.size * (this.page - configurer.getFirstPageNumber()) : 0L;
    }

    public boolean isFullPageRequest() {
        return this.size == 0;
    }

    public boolean isLastPage(int totalNumberOfElements) {
        return isFullPageRequest() || totalNumberOfElements <= (page + (1 - configurer.getFirstPageNumber())) * size;
    }

}
