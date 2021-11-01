package com.dmdev.dto;

import com.dmdev.entity.PersonalInfo;
import com.dmdev.entity.Role;
import com.dmdev.validation.UpdateCheck;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record UserCreateDto(
                            @Valid
                            PersonalInfo personalInfo,
                            @NotNull
                            String username,
                            String info,
                            @NotNull(groups = UpdateCheck.class)
                            Role role,
//                            @ValidCompany
                            Integer companyId) {
}
