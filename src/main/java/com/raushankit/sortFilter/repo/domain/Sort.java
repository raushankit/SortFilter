package com.raushankit.sortFilter.repo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class Sort {

    /**
     * field with which data will be sorted
     */
    private String field;

    /**
     * direction of sorting field
     */
    private Direction direction;

    enum Direction {
        ASC, DESC, UNDEF
    }
}
