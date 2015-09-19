package WorkoutFiles;

/**
 * Created by Brandon on 19/09/2015.
 *
 *
 * a workout consists of 7 workout days
 */
public class Workout {

    private WorkoutDay days[] = new WorkoutDay[7];
    private String name;

    public void Workout(String woName)
    {
        name = woName;
        //Initializes each of the 7 workout days that this workout consists of
        for(int i=0;i<days.length;i++)
        {
            days[i] = new WorkoutDay();
        }
    }
}

