package main.data.Web;

public interface MoviesData {

    String moviesURL = "movies/search/6174af3692a109001a9dc6bc";

    String keywordPlaceholder = "Movie Keyword";

    /* Valid Data */
    String keywordText_Valid = "God";
    String category_Valid = "Action";
    String city_Valid = "Lahore";

    /* InValid Data */
    String keywordText_InValid = "ss";
    String category_InValid = "Actioneeeee";
    String city_InValid = "Lahoreaskdjflksa";

    String topMoviesText = "Top Movies";
    String exploreAllMoviesText = "Explore all Movies";
    String viewMoreMoviesURL = "https://qa.ticketlake.com/movies/viewMore";

    String trendingMoviesText = "Trending Movies";
    String seeAllText = "See All";

    String upComingMoviesText = "Upcoming Movies";

    String showingInCinemasMoviesText = "Showing in Cinemas";


}
