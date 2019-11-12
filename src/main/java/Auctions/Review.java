package Auctions;

public class Review {

    private int rating;
    private String buyerComment;


    public Review(int rating, String buyerComment) {
        this.rating = rating;
        this.buyerComment = buyerComment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }
}
