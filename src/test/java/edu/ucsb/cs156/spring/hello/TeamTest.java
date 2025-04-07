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
    public void equals_same_object_returns_true() {
        assert(team.equals(team));
    }

    @Test
    public void equals_different_class_returns_false() {
        assert(!team.equals("not a team"));
    }

    @Test
    public void equals_same_name_and_same_members_returns_true() {
        Team other = new Team("test-team");
        other.addMember("Saul");
        team.addMember("Saul");
        assert(team.equals(other));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        Team other = new Team("test-team");
        other.addMember("Kev");
        team.addMember("Saul");
        assert(!team.equals(other));
    }


    @Test
    public void hashCode_returns_the_same_hashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
   
    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695; 
        assertEquals(-1226298695, result);
    }

    

}
