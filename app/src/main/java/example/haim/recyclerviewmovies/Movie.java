package example.haim.recyclerviewmovies;

import java.util.Arrays;



public class Movie {
    private final String title;
    private final String[] genres;
    private final int year;
    private double rating; //8.4
    private final String youTubeUrl;
    private final int thumbnailResId; //R.drawable.a1

    public Movie(String youTubeUrl, String title, int year, double rating, int thumbnailResId, String... genres) { //var args ... must always be at the end
        this.title = title;
        this.genres = genres;
        this.year = year;
        this.rating = rating;
        this.youTubeUrl = youTubeUrl;
        this.thumbnailResId = thumbnailResId;
    }

    public int getThumbnailResId() {
        return thumbnailResId;
    }

    public String getTitle() {
        return title;
    }

    public String[] getGenres() {
        return genres;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getYouTubeUrl() {
        return youTubeUrl;
    }
// because it is the only item who not final only rating can have setter.
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", year=" + year +
                ", rating=" + rating +
                ", youTubeUrl='" + youTubeUrl + '\'' +
                '}';
    }


}
