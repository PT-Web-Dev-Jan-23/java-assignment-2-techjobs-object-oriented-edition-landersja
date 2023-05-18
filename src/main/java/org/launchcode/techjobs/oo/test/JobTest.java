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
    public void testSettingJobId(){

Job jobOne = new Job();

Job jobTwo = new Job();

assertNotEquals(jobOne.getId(), jobTwo.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob.equals(testJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', testJob.toString().charAt(0));
        assertEquals('\n', testJob.toString().charAt(testJob.toString().length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\nID: " + testJob.getId() + "\nName: Product tester" + "\nEmployer: ACME" + "\nLocation: Desert" + "\nPosition Type: Quality control" + "\nCore Competency: Persistence\n"
                , testJob.toString());


    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals( "\nID: " + testJob.getId() + "\nName: Data not available" + "\nEmployer: Data not available" + "\nLocation: Data not available" + "\nPosition Type: Data not available" + "\nCore Competency: Data not available\n" ,  testJob.toString());
    }


}


