package com.thenogicode.testbenchapi.models;

import javax.persistence.Entity;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {
	
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
}
