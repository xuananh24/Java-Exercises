import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateManager {
    private List<Candidate> candidates;

    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
    }

    public void showInfor() {
        candidates.forEach(candidate -> System.out.println(candidate.toString()));
    }

    public Optional<Candidate> findById(String id) {
        return candidates.stream().filter(candidate -> candidate.getId().equals(id)).findFirst();
    }
}
