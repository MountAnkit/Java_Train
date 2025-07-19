public class Day10
{
    public static class YoException extends Exception
    {
        YoException(String message)
        {
            super(message);
        }
    }

    public static void main(String[] args) throws YoException
    {
        int x = 10,y = 20;
        if(y>x)
        {
            throw new YoException(("Invalid values: y should not be greater than x"));
        }
        int result = x/y;
        System.out.println("Result: "+result);
    }
}
