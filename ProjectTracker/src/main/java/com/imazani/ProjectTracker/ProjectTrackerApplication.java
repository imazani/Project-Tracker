package com.imazani.ProjectTracker;

import com.imazani.ProjectTracker.model.Note;
import com.imazani.ProjectTracker.model.Profile;
import com.imazani.ProjectTracker.model.Project;
import com.imazani.ProjectTracker.repository.ProjectRepository;
import com.imazani.ProjectTracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class ProjectTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProjectRepository projectRepository, UserRepository userRepository ) {
		return args -> {
			AggregateReference<Profile, Integer> ishe = AggregateReference.to(userRepository.save(new Profile(null, "Ishe", "Mazani","ishemazani@gmail.com")).id());
			Project project = new Project("Queued", "Design", ishe);
			project.addNote(new Note("imazani", "Ishe will email the requester for this project to set up a meeting to discuss the design"));
			projectRepository.save(project);
		};
	}

}
