package pojo;

public class OnStrikeBatsman {
    String onStrike;
    String nonStrike;
    int listIndexForNewBatsman;

    public OnStrikeBatsman(){}

    public OnStrikeBatsman(String onStrike, String nonStrike){
        this.onStrike = onStrike;
        this.nonStrike = nonStrike;
    }

    public OnStrikeBatsman(String onStrike, int listIndexForNewBatsman){
        this.onStrike = onStrike;
        this.listIndexForNewBatsman = listIndexForNewBatsman;
    }

    public int getListIndexForNewBatsman() {
        return listIndexForNewBatsman;
    }

    public void setListIndexForNewBatsman(int listIndexForNewBatsman) {
        this.listIndexForNewBatsman = listIndexForNewBatsman;
    }

    public String getOnStrike() {
        return onStrike;
    }

    public void setOnStrike(String onStrike) {
        this.onStrike = onStrike;
    }

    public String getNonStrike() {
        return nonStrike;
    }

    public void setNonStrike(String nonStrike) {
        this.nonStrike = nonStrike;
    }
}

