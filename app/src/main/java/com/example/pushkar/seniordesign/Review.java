package com.example.pushkar.seniordesign;

/**
 * Created by pushkar on 11/11/17.
 */

public class Review {
    private int id;
    private String author;
    private String comment;
    private double reviewStars;
    int categoryOneStar;
    int categoryTwoStar;
    int categoryThreeStar;
    int categoryFourStar;
    int categoryFiveStar;


    public Review(int id, String author, String comment, double reviewStars, int categoryOneStar, int categoryTwoStar, int categoryThreeStar, int categoryFourStar, int categoryFiveStar) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.reviewStars = reviewStars;
        this.categoryOneStar = categoryOneStar;
        this.categoryTwoStar = categoryTwoStar;
        this.categoryThreeStar = categoryThreeStar;
        this.categoryFourStar = categoryFourStar;
        this.categoryFiveStar = categoryFiveStar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public double getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(double reviewStars) {
        this.reviewStars = reviewStars;
    }

    public int getCategoryOneStar() {
        return categoryOneStar;
    }

    public void setCategoryOneStar(int categoryOneStar) {
        this.categoryOneStar = categoryOneStar;
    }

    public int getCategoryTwoStar() {
        return categoryTwoStar;
    }

    public void setCategoryTwoStar(int categoryTwoStar) {
        this.categoryTwoStar = categoryTwoStar;
    }

    public int getCategoryThreeStar() {
        return categoryThreeStar;
    }

    public void setCategoryThreeStar(int categoryThreeStar) {
        this.categoryThreeStar = categoryThreeStar;
    }

    public int getCategoryFourStar() {
        return categoryFourStar;
    }

    public void setCategoryFourStar(int categoryFourStar) {
        this.categoryFourStar = categoryFourStar;
    }

    public int getCategoryFiveStar() {
        return categoryFiveStar;
    }

    public void setCategoryFiveStar(int categoryFiveStar) {
        this.categoryFiveStar = categoryFiveStar;
    }
}
