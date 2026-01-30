package dev.studyAI.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.studyAI.History.HistoryModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_user")
@DynamicUpdate
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private LocalDate userAge;

    @Column(name = "user_gmail", unique = true)
    private String userGmail;

    @OneToMany(mappedBy = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<HistoryModel> historyModelsSet = new HashSet<>();
}
