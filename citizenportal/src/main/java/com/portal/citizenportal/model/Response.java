package com.portal.citizenportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
        private T payload;
        private String message;

}
