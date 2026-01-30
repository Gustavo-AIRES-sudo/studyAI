package dev.studyAI.History;
import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.studyAI.History.Categories.CategoryEnum;
import dev.studyAI.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_history")
@DynamicUpdate
public class HistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum category;

    @Column(name = "idea")
    private String historyIdea;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user_id;
}
