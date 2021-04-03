package com.cbrl.spring.cloud.domain.user.dto;

import com.cbrl.spring.cloud.base.model.BaseDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto extends BaseDto {
   private String firstName;
   private String lastName;
   private String email;
}
