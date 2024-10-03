package model;

public class SleepRecord {

    private String name;
    private String dayOfSleep;
    private String sleepTime;
    private String dayOfWake;
    private String wakeTime;
    private int userId;

    // Default constructor
    public SleepRecord() {}

    // Parameterized constructor
    public SleepRecord(String name, String dayOfSleep, String sleepTime, String dayOfWake, String wakeTime, int userId) {
        this.name = name;
        this.dayOfSleep = dayOfSleep;
        this.sleepTime = sleepTime;
        this.dayOfWake = dayOfWake;
        this.wakeTime = wakeTime;
        this.userId = userId;
    }

    // Setters and Getters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfSleep() {
        return dayOfSleep;
    }

    public void setDayOfSleep(String dayOfSleep) {
        this.dayOfSleep = dayOfSleep;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getDayOfWake() {
        return dayOfWake; 
    }

    public void setDayOfWake(String dayOfWake) {
        this.dayOfWake = dayOfWake;
    }

    public String getWakeTime() {
        return wakeTime;
    }

    public void setWakeTime(String wakeTime) {
        this.wakeTime = wakeTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
