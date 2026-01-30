package dev.studyAI.History;

import dev.studyAI.User.UserModel;
import org.mapstruct.*;

@Mapper(componentModel="spring")
public interface HistoryMapper {

    @Mapping(source = "user_id.id", target = "user_id")
    HistoryDTO map(HistoryModel historyModel);

    @Mapping(source = "user_id", target = "user_id.id")
    HistoryModel map(HistoryDTO historyDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHistoryFromDto(HistoryDTO dto, @MappingTarget HistoryModel entity);

    //TODO: IMPLEMENTAR MÉTODO MELHOR
    default UserModel map(Long id) {
        if (id == null) return null;
        UserModel user = new UserModel();
        user.setId(id);
        return user;
    }
}
