package org.ruletka.entites;

public class Result {
    private int userId;
    private int payout;

    public Result(int userId, int payout) {
        this.userId = userId;
        this.payout = payout;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }
}
