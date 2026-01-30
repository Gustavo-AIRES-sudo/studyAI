package dev.studyAI.History;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.studyAI.History.Categories.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private Long id;

    @JsonProperty("category")
    private CategoryEnum category;

    @JsonProperty("idea")
    private String historyIdea;

    @JsonProperty("user_id")
    private Long user_id;
}