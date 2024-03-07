package com.imazani.ProjectTracker.dto;

import com.imazani.ProjectTracker.model.Project;
import com.imazani.ProjectTracker.model.Profile;

public record ProjectDetails(Project project, Profile user) {
}
