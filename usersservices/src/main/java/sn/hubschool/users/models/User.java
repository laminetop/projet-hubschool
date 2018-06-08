package sn.hubschool.users.models;



import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Users")
@Data
public class User  implements Serializable{



    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Email
    @Length(max = 250)
    @Column(unique = true, nullable = false, length = 250)
    private String username;

    @Column(nullable = true, length = 200)
    private String password;

    @Length(max = 100)
    @Column(nullable = true, length = 100)
    private String firstname;

    @Length(max = 100)
    @Column(nullable = true, length = 100)
    private String lastname;

    @Column
    private boolean enabled;


    @Column
    private Date lastLoginTime;

  //  @Transient
  //  private String newPassword;

  //  @Transient
  //  private String confirmPassword;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Authoritie> authorities;


    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Language language;



}
