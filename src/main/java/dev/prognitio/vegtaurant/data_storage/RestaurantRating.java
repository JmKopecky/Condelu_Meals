package dev.prognitio.vegtaurant.data_storage;

import jakarta.persistence.*;

@Entity
public class RestaurantRating implements Comparable<RestaurantRating> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Account reviewer;
    private int rating;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getReviewer() {
        return reviewer;
    }

    public void setReviewer(Account reviewer) {
        this.reviewer = reviewer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int compareTo(RestaurantRating o) {
        return this.rating - o.rating;
    }
}
