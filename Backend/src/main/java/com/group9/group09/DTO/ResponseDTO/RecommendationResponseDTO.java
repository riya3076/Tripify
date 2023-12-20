package com.group9.group09.DTO.ResponseDTO;

import java.util.List;

public class RecommendationResponseDTO {

    private ActivityResponseDTO activityResponseDTO;
    private List<PlaceResponseDTO> placeResponseDTO;

    public ActivityResponseDTO getActivityResponseDTO() {
        return activityResponseDTO;
    }

    public void setActivityResponseDTO(ActivityResponseDTO activityResponseDTO) {
        this.activityResponseDTO = activityResponseDTO;
    }

    public List<PlaceResponseDTO> getPlaceResponseDTO() {
        return placeResponseDTO;
    }

    public void setPlaceResponseDTO(List<PlaceResponseDTO> placeResponseDTO) {
        this.placeResponseDTO = placeResponseDTO;
    }
}
