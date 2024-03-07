package com.imazani.ProjectTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public record Profile(
        @Id @JsonIgnore Integer id,
        String firstName,
        String lastName,
        String email
) { }
