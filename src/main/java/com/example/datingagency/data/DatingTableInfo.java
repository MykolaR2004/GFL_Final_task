package com.example.datingagency.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link DatingTable}
 */
public interface DatingTableInfo {
    Integer getId();
    String getFirstPerson();

    String getSecondPerson();

//    @Value("#{target.first_person+ ' and '+target.second_person}")
//    String getConvergedPair();
}