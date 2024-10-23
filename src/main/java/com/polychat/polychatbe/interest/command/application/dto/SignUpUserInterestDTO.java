
package com.polychat.polychatbe.interest.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpUserInterestDTO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("interest_list")
    private List<Long> interestList;
}
