package com.mallinapps.designdomain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
public class PageConfigurer {

    public static final int DEFAULT_SIZE = 20;
    public static final FirstPage DEFAULT_FIRST_PAGE = FirstPage.ZERO;

    @Builder.Default
    private FirstPage firstPage = DEFAULT_FIRST_PAGE;

    @Builder.Default
    @Setter
    private int defaultSize = DEFAULT_SIZE;

    public static PageConfigurer createDefault() {
        return new PageConfigurer();
    }

    public int getFirstPageNumber() {
        return firstPage.getNumber();
    }

}
