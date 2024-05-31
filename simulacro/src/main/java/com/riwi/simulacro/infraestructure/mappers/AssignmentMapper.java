package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.AssignmentRequest;
import com.riwi.simulacro.api.dto.response.AssignmentResponse;
import com.riwi.simulacro.domain.entities.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface AssignmentMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lessonId.id", source = "lessonId")
    })
    Assignment toAssignment(AssignmentRequest assignmentRequest);

    AssignmentResponse toAssignmentResponse(Assignment assignment);

    @Mapping(target = "lessonId.id", source = "lessonId")
    void updateFromAssignmentRequest(AssignmentRequest assignmentRequest, @MappingTarget Assignment assignment);
}
