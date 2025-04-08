package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_false_when_same_name_different_members() {
        Team other = new Team("test-team");
        other.addMember("NotSaul");
        team.addMember("Saul");
        assert(!team.equals(other));
    }

    @Test
    public void equals_returns_false_when_different_name_same_members() {
        Team other = new Team("another-team");
        other.addMember("Saul");
        team.addMember("Saul");
        assert(!team.equals(other));
    }

    @Test
    public void equals_returns_false_when_different_name_and_members() {
        Team other = new Team("another-team");
        other.addMember("NotSaul");
        team.addMember("Saul");
        assert(!team.equals(other));
    }



    @Test
    public void hashCode_same_name_and_members_same_hash() {
        Team t1 = new Team("test-team");
        t1.addMember("Saul");
        Team t2 = new Team("test-team");
        t2.addMember("Saul");

        assertEquals(t1.hashCode(), t2.hashCode());
    }
   
    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695; 
        assertEquals(-1226298695, result);
    }

    @Test
    public void equals_returns_true_when_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_false_when_not_team_instance() {
        assert(!team.equals("NotATeam"));
    }

    @Test
    public void equals_returns_true_when_same_name_and_same_members() {
        Team other = new Team("test-team");
        other.addMember("Saul");
        team.addMember("Saul");
        assert(team.equals(other));
    }


}
