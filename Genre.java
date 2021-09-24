public enum Genre {
    Classical, Country, Jazz, Pop, Unknown;

    public static boolean includes(String string){
        if(string.equals("Classical") || string.equals("Country") || string.equals("Jazz") || string.equals("Pop")){
            return true;
        }else {
            return false;
        }
    }
}
