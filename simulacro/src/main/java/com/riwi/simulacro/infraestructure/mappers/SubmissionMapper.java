package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.SubmissionRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;
import com.riwi.simulacro.domain.entities.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AssignmentMapper.class})
public interface SubmissionMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "assignmentId.id", source = "assignmentId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    Submission toSubmission(SubmissionRequest submissionRequest);

    SubmissionResponse toSubmissionResponse(Submission submission);

    @Mappings({
            @Mapping(target = "assignmentId.id", source = "assignmentId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    void updateFromSubmissionRequest(SubmissionRequest submissionRequest, @MappingTarget Submission submission);
}
