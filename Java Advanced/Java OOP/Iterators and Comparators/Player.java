public class Player {

    private static final double TOTAL_COUNT_OF_SKILLS = 5;

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {

        Team.verifyNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {

        verifyStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {

        verifyStats(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {

        verifyStats(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {

        verifyStats(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {

        verifyStats(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / TOTAL_COUNT_OF_SKILLS;
    }

    private void verifyStats(int endurance, String skill) {

        if(endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", skill));
        }
    }
}
