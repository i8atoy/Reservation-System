public class Musician {
    private final String name;
    private String instrument;
    private int score;

    public Musician(String name, String instrument, int rating){
        this.name = name;
        this.instrument = instrument;
        this.score = rating;
    }

    public Musician(String name, int score){
        this.name = name;
        this.instrument = "";
        this.score = score;
    }

    //getter for name
    public String getName(){
        return name;
    }
    //getter for instrument
    public String getInstrument(){
        return instrument;
    }
    //setter for instrument, might change.
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
    //getter for rating
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public String toString(){
        return "Name: " + name + ", Instrument: " + (instrument.isEmpty() ? "Not specified" : instrument) + ", Score: " + score;
    }
}
