package model.simulation;

/**
 * Simulation Events.
 */
public class Event implements Comparable<Event> {

    private final EventType type;
    private final Customer customer;
    private final double initTime;
    private int queueLength;

    public int getQueueALength() {
        return queueALength;
    }

    public void setQueueALength(int queueALength) {
        this.queueALength = queueALength;
    }

    private int queueALength;
    private Status attentionChanelStatus;

    public Customer.CustomerType getAttentionChannelCustomer() {
        return attentionChannelCustomer;
    }

    @Override public boolean equals(Object obj) {
        return false;
    }

    public void setAttentionChannelCustomer(Customer.CustomerType attentionChannelCustomer) {
        this.attentionChannelCustomer = attentionChannelCustomer;
    }

    private Customer.CustomerType attentionChannelCustomer;
    private  double deltaTime;
    private final boolean silent;
    private String comment;
    private double remainingTime;

    /** Event Type. */
    public EventType getType() { return type; }

    /** Event Customer. */
    public Customer getCustomer() { return customer; }

    /** Event start initTime. */
    public double getInitTime() { return initTime; }

    /** Event for type customer and start initTime. */
    public Event(EventType t, Customer c, double time, boolean silent) {
        type = t;
        customer = c;
        initTime = time;
        this.silent = silent;
        remainingTime = 0.0;
    }

    @Override public int compareTo(Event o) {
        if (initTime > o.getInitTime()) return 2;
        else if (initTime == o.getInitTime()) {
            if (getType() == o.getType() && getCustomer().equals(o.customer)) return 0;
            else return 1;
        }
        else return -1;
    }

    @Override public String toString() {
        return initTime + " : " + type.name + "  " + (customer != null ? customer.getType().toString()  : "none" ) + " L(n) : " + queueLength + " Status : " + attentionChanelStatus;
    }

    public int getQueueLength() {
        return queueLength;
    }

    public Status getAttentionChanelStatus() {
        return attentionChanelStatus;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public Event queueLength(int queueLength) {
        this.queueLength = queueLength;
        return this;
    }

    public Event attentionChanelStatus(Status attentionChanelStatus) {
        this.attentionChanelStatus = attentionChanelStatus;
        return this;

    }

    public Event deltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
        return this;
    }

    public boolean isSilent() { return silent; }


    public String getComment() { return comment; }

    public Event comment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getRemainingTime() { return remainingTime; }

    public void setRemainingTime(double remainingTime) { this.remainingTime = remainingTime; }

    public enum EventType {

        INITIATION("INICIO"), ARRIVAL("ARRIBO"), DEPARTURE("SALIDA");

        private final String name;

        EventType(String name) {
            this.name = name;
        }

        @Override public String toString() {
            return name;
        }

    }


    public enum Status {
        EMPTY, OCCUPIED
    }
}
