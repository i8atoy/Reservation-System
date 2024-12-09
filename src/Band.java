import java.util.ArrayList;

public class Band {
    private String name;
    private ArrayList<Musician> musicians;

    //if no list of musicians is given
    public Band(String name){
        this.name = name;
        this.musicians = new ArrayList<Musician>();
    }
    //if list of musicians is given
    public Band(String name, ArrayList<Musician> musicians){
        this.name = name;
        this.musicians = musicians;
    }

    public String getName(){
        return name;
    }
    public ArrayList<Musician> getMusicians(){
        //returns this so that whoever calls this function doesn't have address to original list.
        return new ArrayList<Musician>(musicians);
    }

    public void addMusician(Musician musician){
        musicians.add(musician);
    }
    public void removeMusician(Musician musician){
        musicians.remove(musician);
    }
    public String toString(){
        return getName();
    }



    public int calculateScore(){
        int totalScore = 0;
        for(Musician musician : musicians){
            totalScore += musician.getScore();
        }
        return totalScore;
    }
}
