package dev.studyAI.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.studyAI.History.HistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_age")
    private LocalDate userAge;

    @JsonProperty("user_gmail")
    private String userGmail;

    private Set<HistoryDTO> historyModelsSet;
}