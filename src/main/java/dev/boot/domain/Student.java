package dev.boot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(name = "U_email", columnNames = "email")

        }
)
@Getter
@Setter
@SequenceGenerator(name = "ID_GEN", sequenceName = "ID_SEQ", allocationSize = 1)
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
    private long Id;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String firstName;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String lastName;

    @Column
    @Email
    private String email;

    @Column
    private LocalDate birthday;

//    @OneToMany(mappedBy = "course")
//    private Set<CourseRegistration> registrations;


}
