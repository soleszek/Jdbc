package Entity;

public class Member {
    private Long id;
    private String name;
    private String lastName;
    private Integer startNumber;
    private Integer runId;

    public Member(Long id, String name, String lastName, Integer startNumber, Integer runId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.startNumber = startNumber;
        this.runId = runId;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public Integer getRunId() {
        return runId;
    }

    public void setRunId(Integer runId) {
        this.runId = runId;
    }
}
