package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
public class ArrayListReviewDto {
    ArrayList<ReviewDTO> reviewDTOArrayList;
}


