public class Math
{
    private Math() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of a static class Math.");
    }

    public static long StirlingSecond(final int n, final int k)
    {
        if(n < 0 || k < 0)
        {
            throw new IllegalArgumentException("Arguments cannot be negative (" + n + ", " + k + ")");
        }
        else if((k==0)&&(n==0))
        {
            return 1;
        }
        else if ((k==0)&&(!(n==0)))
        {
            return 0;
        }
        else if(k > n)
        {
            return 0;
        }

        return StirlingSecond(n-1, k-1) + k*StirlingSecond(n-1, k);
    }

    public static long StirlingFirst(final int n, final int k)
    {
        if(n < 0 || k < 0)
        {
            throw new IllegalArgumentException("Arguments cannot be negative (" + n + ", " + k + ")");
        }
        else if((k==0)&&(n==0))
        {
            return 1;
        }
        else if ((k==0)&&(!(n==0)))
        {
            return 0;
        }
        else if(k > n)
        {
            return 0;
        }

        return StirlingFirst(n-1, k-1) + (n-1)*StirlingFirst(n-1, k);
    }
}