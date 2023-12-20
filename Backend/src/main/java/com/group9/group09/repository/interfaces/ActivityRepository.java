package com.group9.group09.repository.interfaces;
import com.group9.group09.model.Activity;
import com.group9.group09.model.City;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    Optional<Activity> findByActivityId(Integer activityID);
    Optional<Activity> findByActivityName(String activityName);

    List<Activity> getActivitiesbyCityID(Integer cityID);


    List<Activity> getAllActivities();
    
    List<Activity> getActivitiesByInterest(String interest);

    Optional<Activity> isActivityPresent(String activityName, Integer cityId);

    int addPlace(String activityName, String description, Integer cityId, String interest);
}
