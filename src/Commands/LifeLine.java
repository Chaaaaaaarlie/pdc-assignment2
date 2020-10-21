package Commands;

abstract class LifeLine {
    protected boolean active = true;
    
    public abstract void use();
    public abstract boolean isActive();
}
