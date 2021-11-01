package com.dmdev.dto;

import com.dmdev.entity.PersonalInfo;
import com.dmdev.entity.Role;

public record UserReadDto(Long id,
                          PersonalInfo personalInfo,
                          String username,
                          String info,
                          Role role,
                          CompanyReadDto company) {
}
