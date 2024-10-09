package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TeamTest {

    Team team;
    Team defaultTeam;
    Team sameTeam;
    Team differentTeamName;
    Team differentTeamMembers;
    Team differentTeamBoth;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");  
       
        defaultTeam = new Team("test-team"); 
        defaultTeam.addMember("member1");

        sameTeam = new Team("test-team");  
        sameTeam.addMember("member1");

        differentTeamName = new Team("different-team");
        differentTeamName.addMember("member1");

        differentTeamMembers = new Team("test-team");
        differentTeamMembers.addMember("member2");

        differentTeamBoth = new Team("different-team");
        differentTeamBoth.addMember("member2");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

     // Test case 1: Same object
    @Test
    public void testEquals_sameObject() {
        assertTrue(defaultTeam.equals(defaultTeam)); // Comparing the object to itself
    }

    // Test case 2: Different class
    @Test
    public void testEquals_differentClass() {
        assertFalse(defaultTeam.equals("a string object")); // Comparing to a different class
    }

    // Test case 3: T, T - Same name and same members
    @Test
    public void testEquals_sameNameSameMembers() {
        assertTrue(defaultTeam.equals(sameTeam)); // Should be true as names and members are the same
    }

    // Test case 3: T, F - Same name, different members
    @Test
    public void testEquals_sameNameDifferentMembers() {
        assertFalse(defaultTeam.equals(differentTeamMembers)); // Should be false as members differ
    }

    // Test case 3: F, T - Different name, same members
    @Test
    public void testEquals_differentNameSameMembers() {
        assertFalse(defaultTeam.equals(differentTeamName)); // Should be false as names differ
    }

    // Test case 3: F, F - Different name and different members
    @Test
    public void testEquals_differentNameDifferentMembers() {
        assertFalse(defaultTeam.equals(differentTeamBoth)); // Should be false as both name and members differ
    }

    @Test
    public void test_gap_in_hashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        Team t3 = new Team();
        t3.setName("foo");
        t3.addMember("baz");
        assertNotEquals(t1.hashCode(), t3.hashCode());
        Team t4 = new Team();
        t4.setName("bar");
        t4.addMember("bar");
        assertNotEquals(t1.hashCode(), t4.hashCode());
    }

}
