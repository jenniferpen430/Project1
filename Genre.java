/**
 * The Genre enum class stores the value of each music genre that the albums that are passed into
 * the Collection could be. If the inputted album doesn't have a genre that matches any of the known ones,
 * it is classified as unknown.
 */

public enum Genre {
    Classical, Country, Jazz, Pop, Unknown;

    /**
     * The includes method takes a string as an argument and returns a boolean based on whether that string
     * is any of the four genres. If it is, the method returns true, otherwise it returns false.
     * @param string
     * @return
     */
    public static boolean includes(String string){
        if(string.equals("Classical") || string.equals("Country") || string.equals("Jazz") || string.equals("Pop")){
            return true;
        }else {
            return false;
        }
    }
}
