package WorkoutFiles;

/**
 * Created by Brandon on 19/09/2015.
 *
 * a workout day consists of many different exercises
 */
public class WorkoutDay {

    private Exercise exercises[] = new Exercise[15];

    public WorkoutDay()
    {
        for(int i = 0;i<exercises.length;i++)
        {
            exercises[i] = new Exercise();
        }
    }
}
