package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().toString());
        assertEquals("Desert", job.getLocation().toString());
        assertEquals("Quality control", job.getPositionType().toString());
        assertEquals("Persistence", job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality () {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testingString = jobOne.toString();
        char character = '\n';

        assertEquals(character, testingString.charAt(0));
        assertEquals(character, testingString.charAt(testingString.length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testingString = "\nID: " + jobOne.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";

        assertEquals(testingString, jobOne.toString());
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job jobOne = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String testingString = "\nID: " + jobOne.getId() + "\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n";

        assertEquals(testingString, jobOne.toString());
    }

}
