public enum Animals implements Being
{
    DOG,CAT;      

    public String getName()
    {
        return Name().getName();
    }

    private Being Name()
    {
        switch(this)
        {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            default:
                throw new IllegalArgumentException("Unknown animal");
            
        }
    }
}
