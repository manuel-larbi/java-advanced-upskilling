package weektwo.creational.builder;

import weektwo.creational.builder.search.SearchQuery;
import weektwo.creational.builder.search.SearchQueryBuilder;
import weektwo.creational.builder.user.User;
import weektwo.creational.builder.user.UserBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user1 = new UserBuilder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .build();

        User user2 = new UserBuilder()
                .build();

        System.out.println(user1);
        System.out.println(user2);


        SearchQuery searchQuery1 = new SearchQueryBuilder()
                .keyword("laptop")
                .categories(Arrays.asList("electronics", "computers"))
                .minPrice(500.00)
                .maxPrice(1500.00)
                .sortBy("price")
                .build();

        SearchQuery searchQuery2 = new SearchQueryBuilder()
                .keyword("book")
                .categories(Arrays.asList("fiction", "science"))
                .sortBy("popularity")
                .build();

        System.out.println(searchQuery1);
        System.out.println(searchQuery2);
    }
}
