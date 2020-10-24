package Commands;

abstract class LifeLineAbstract implements LifeLine {
    protected boolean active = true;
    
    @Override
    public abstract void use();
    
    @Override
    public abstract String getAnswer();
    
    @Override
    public abstract String toString();
}
