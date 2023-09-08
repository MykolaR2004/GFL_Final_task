package com.example.datingagency.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Client}
 */
public interface ClientInfo {
    Integer getId();

//    @Value("#{target.name+ ' '+target.surname}")
//    String getFullName();
}