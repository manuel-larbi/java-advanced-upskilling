package weektwo.creational.builder.search;

import java.util.List;

public class SearchQuery {
    private final String keyword;
    private final List<String> categories;
    private final Double minPrice;
    private final Double maxPrice;
    private final String sortBy;

    public SearchQuery(SearchQueryBuilder builder) {
        this.keyword = builder.keyword;
        this.categories = builder.categories;
        this.minPrice = builder.minPrice;
        this.maxPrice = builder.maxPrice;
        this.sortBy = builder.sortBy;
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "keyword='" + keyword + '\'' +
                ", categories=" + categories +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", sortBy='" + sortBy + '\'' +
                '}';
    }
}

