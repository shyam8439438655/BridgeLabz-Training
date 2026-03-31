class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

interface ElectionService {
    void registerVoter(int voterId, String voterName);
    void addCandidate(int candidateId, String candidateName);
    void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    void showResult();
}

class Voter {
    int voterId;
    String name;
    boolean hasVoted;

    Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }
}

class Candidate {
    int candidateId;
    String name;
    int votes;

    Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }
}

class Election implements ElectionService {

    Voter[] voters = new Voter[10];
    Candidate[] candidates = new Candidate[10];

    int voterCount = 0;
    int candidateCount = 0;

    public void registerVoter(int voterId, String voterName) {
        voters[voterCount++] = new Voter(voterId, voterName);
        System.out.println("Voter Registered: " + voterName);
    }

    public void addCandidate(int candidateId, String candidateName) {
        candidates[candidateCount++] = new Candidate(candidateId, candidateName);
        System.out.println("Candidate Added: " + candidateName);
    }

    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {

        Voter voter = null;
        Candidate candidate = null;

        for (int i = 0; i < voterCount; i++) {
            if (voters[i].voterId == voterId) {
                voter = voters[i];
            }
        }

        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].candidateId == candidateId) {
                candidate = candidates[i];
            }
        }

        if (voter.hasVoted) {
            throw new DuplicateVoteException("Voter already voted!");
        }

        voter.hasVoted = true;
        candidate.votes++;

        System.out.println(voter.name + " voted for " + candidate.name);
    }

    public void showResult() {
        System.out.println("\n--- Election Result ---");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i].name + " : " + candidates[i].votes + " votes");
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {

        Election election = new Election();

        election.registerVoter(1, "Rahul");
        election.registerVoter(2, "Anita");

        election.addCandidate(101, "Candidate A");
        election.addCandidate(102, "Candidate B");

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
            election.castVote(1, 102); // duplicate vote
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.showResult();
    }
}
