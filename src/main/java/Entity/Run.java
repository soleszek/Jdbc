package Entity;

import java.util.Date;

public class Run {
    private Long id;
    private String name;
    private String place;
    private Date startTime;
    private Date startDate;
    private Integer memberLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(Integer memberLimit) {
        this.memberLimit = memberLimit;
    }

    public Run(){};

    public Run(Long id, String name, String place, Date startTime, Date startDate, Integer memberLimit) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.startTime = startTime;
        this.startDate = startDate;
        this.memberLimit = memberLimit;
    }
}
