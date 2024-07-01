package weektwo.creational.builder.search;

import java.util.List;

public class SearchQueryBuilder {
    public String keyword;
    public List<String> categories;
    public Double minPrice;
    public Double maxPrice;
    public String sortBy;

    public SearchQueryBuilder keyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public SearchQueryBuilder categories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public SearchQueryBuilder minPrice(Double minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public SearchQueryBuilder maxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public SearchQueryBuilder sortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public SearchQuery build() {
        return new SearchQuery(this);
    }
}
