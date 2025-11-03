package com.waihon.designpatterns.mosh.composite.exercise;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.waihon.designpatterns.mosh.utils.StringUtils.countOfSubstring;

public class CompositeTest {
    private final String TRUCK_MESSAGE = "Deploying a truck";
    private final String HUMAN_RESOURCE_MESSAGE = "Deploying a human resource";


    @Test
    void deployATruck() throws Exception {
        var truck = new Truck();
        var text = tapSystemOut(() -> {
            truck.deploy();
        });

        assertThat(text).contains(TRUCK_MESSAGE);

    }

    @Test
    void deployAHumanResource() throws Exception {
        var human = new HumanResource();
        var text = tapSystemOut(() -> {
            human.deploy();
        });

        assertThat(text).contains(HUMAN_RESOURCE_MESSAGE);
    }

    @Test
    void deployASubTeam() throws Exception {
        var subTeam = new Team();
        subTeam.add(new Truck());
        subTeam.add(new HumanResource());
        subTeam.add(new HumanResource());

        var text = tapSystemOut(() -> {
            subTeam.deploy();
        });

        assertThat(text).contains(TRUCK_MESSAGE);
        assertThat(text).contains(HUMAN_RESOURCE_MESSAGE);
        var truckCount = countOfSubstring(text, TRUCK_MESSAGE);
        assertThat(truckCount).isEqualTo(1);
        var humanCount = countOfSubstring(text, HUMAN_RESOURCE_MESSAGE);
        assertThat(humanCount).isEqualTo(2);
    }

    @Test
    void deployATeam() throws Exception {
        var subTeam1 = new Team();
        subTeam1.add(new Truck());
        subTeam1.add(new HumanResource());
        subTeam1.add(new HumanResource());

        var subTeam2 = new Team();
        subTeam2.add(new HumanResource());
        subTeam2.add(new Truck());
        subTeam2.add(new HumanResource());

        var team = new Team();
        team.add(subTeam2);
        team.add(subTeam1);

        var text = tapSystemOut(() -> {
            team.deploy();
        });

        assertThat(text).contains(TRUCK_MESSAGE);
        assertThat(text).contains(HUMAN_RESOURCE_MESSAGE);
        var truckCount = countOfSubstring(text, TRUCK_MESSAGE);
        assertThat(truckCount).isEqualTo(2);
        var humanCount = countOfSubstring(text, HUMAN_RESOURCE_MESSAGE);
        assertThat(humanCount).isEqualTo(4);
    }
}
