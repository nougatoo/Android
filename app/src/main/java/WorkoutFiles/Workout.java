package WorkoutFiles;

import java.io.Serializable;

/**
 * Created by Brandon on 19/09/2015.
 *
 *
 * a workout consists of 7 workout days
 */
public class Workout implements Serializable {

    private WorkoutDay days[] = new WorkoutDay[7];
    private String name;

    public void Workout()
    {
        //Initializes each of the 7 workout days that this workout consists of
        for(int i=0;i<days.length;i++)
        {
            days[i] = new WorkoutDay();
        }
    }

    public void setNamme(String newName)
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }
}

