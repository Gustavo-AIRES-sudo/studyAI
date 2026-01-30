package dev.studyAI.History;

import dev.studyAI.User.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T13:48:38-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public HistoryDTO map(HistoryModel historyModel) {
        if ( historyModel == null ) {
            return null;
        }

        HistoryDTO historyDTO = new HistoryDTO();

        historyDTO.setUser_id( historyModelUser_idId( historyModel ) );
        historyDTO.setId( historyModel.getId() );
        historyDTO.setCategory( historyModel.getCategory() );
        historyDTO.setHistoryIdea( historyModel.getHistoryIdea() );

        return historyDTO;
    }

    @Override
    public HistoryModel map(HistoryDTO historyDTO) {
        if ( historyDTO == null ) {
            return null;
        }

        HistoryModel historyModel = new HistoryModel();

        historyModel.setUser_id( historyDTOToUserModel( historyDTO ) );
        historyModel.setId( historyDTO.getId() );
        historyModel.setCategory( historyDTO.getCategory() );
        historyModel.setHistoryIdea( historyDTO.getHistoryIdea() );

        return historyModel;
    }

    @Override
    public void updateHistoryFromDto(HistoryDTO dto, HistoryModel entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getCategory() != null ) {
            entity.setCategory( dto.getCategory() );
        }
        if ( dto.getHistoryIdea() != null ) {
            entity.setHistoryIdea( dto.getHistoryIdea() );
        }
        if ( dto.getUser_id() != null ) {
            entity.setUser_id( map( dto.getUser_id() ) );
        }
    }

    private Long historyModelUser_idId(HistoryModel historyModel) {
        UserModel user_id = historyModel.getUser_id();
        if ( user_id == null ) {
            return null;
        }
        return user_id.getId();
    }

    protected UserModel historyDTOToUserModel(HistoryDTO historyDTO) {
        if ( historyDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( historyDTO.getUser_id() );

        return userModel;
    }
}
