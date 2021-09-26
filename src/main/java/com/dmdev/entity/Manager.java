package com.dmdev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("manager")
public class Manager extends User {

    private String projectName;

    @Builder
    public Manager(Long id, PersonalInfo personalInfo, String username, String info, Role role, Company company, Profile profile, List<UserChat> userChats, String projectName) {
        super(id, personalInfo, username, info, role, company, profile, userChats);
        this.projectName = projectName;
    }
}
