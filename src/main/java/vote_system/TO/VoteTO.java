package vote_system.TO;

import java.io.Serializable;

public class VoteTO implements Serializable {

    private String name;
    private Long countVotes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountVotes() {
        return countVotes;
    }

    public void setCountVotes(Long countVotes) {
        this.countVotes = countVotes;
    }

    public VoteTO(String name, Long countVotes) {
        this.name = name;
        this.countVotes = countVotes;
    }

    @Override
    public String toString() {
        return "VoteTO{" +
                "name='" + name + '\'' +
                ", countVotes=" + countVotes +
                '}';
    }
}
